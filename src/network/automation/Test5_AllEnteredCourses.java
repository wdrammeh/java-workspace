package network.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class Test5_AllEnteredCourses {
    private static final ArrayList<Temp_JustAllCourses> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        final FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);

        final FirefoxDriver driver = new FirefoxDriver(options);

        driver.navigate().to("https://www.utg.gm/login");

        driver.findElement(By.name("email")).sendKeys("21712494@utg.edu.gm");
        driver.findElement(By.name("password")).sendKeys("21712494");

        driver.findElement(By.className("form-group")).submit();

        final WebDriverWait loadWaiter = new WebDriverWait(driver, 5);

        try{
            loadWaiter.until(ExpectedConditions.presenceOfElementLocated(By.className("media-heading")));
            driver.navigate().to("https://www.utg.gm/course-registrations");
            loadWaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("table")));
        }catch (TimeoutException t){//... time ran out
            System.out.println("Time out!");
            return;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return;
        }

        //all the tabs
        final List<WebElement> tabs = loadWaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".nav-tabs > li")));
        //on the grades tab to get all the courses first
        tabs.get(6).click();

        final WebElement gradesTable = driver.findElementsByCssSelector(".table-warning").get(1);
        final WebElement tBody = gradesTable.findElement(By.tagName("tbody"));
        final List<WebElement> rows = tBody.findElements(By.tagName("tr"));

        System.out.println("//"+rows.size()+" courses found");

        for(WebElement t : rows){
            final List<WebElement> data = t.findElements(By.tagName("td"));
            arrayList.add(new Temp_JustAllCourses(data.get(0).getText(),data.get(1).getText(),Double.valueOf(data.get(6).getText())));
        }

        //on the transcript to assign the times - year and semester
        tabs.get(7).click();

        final WebElement transcriptTable = driver.findElementByCssSelector(".table-bordered");
        final WebElement transBody = transcriptTable.findElement(By.tagName("tbody"));
        final List<WebElement> transRows = transBody.findElements(By.tagName("tr"));
        final List<WebElement> semCaptions = transBody.findElements(By.className("warning"));
        System.out.println("//"+semCaptions.size()+" semesters detected");

        String vYear = null;
        String vSemester = null;
        for (WebElement transRow : transRows) {
            if (transRow.getText().contains("Semester")) {
                vYear = transRow.getText().split(" ")[0];
                vSemester = transRow.getText().split(" ")[1] + " Semester";
            } else {
                for (Temp_JustAllCourses a : arrayList) {
                    if (transRow.getText().contains(a.getCode())) {
                        a.setYear(vYear);
                        a.setSemester(vSemester);
                    }
                }
            }
        }

        //going to all the registered courses to assign the lecturers' names
        tabs.get(4).click();

        final WebElement allCourseTable = driver.findElementByCssSelector(".table-warning");
        final WebElement tableBody = allCourseTable.findElement(By.tagName("tbody"));
        final List<WebElement> allRows = tableBody.findElements(By.tagName("tr"));

        int l = 0;
        while (l < allRows.size()) {
            final List<WebElement> data = allRows.get(l).findElements(By.tagName("td"));
            for (Temp_JustAllCourses course: arrayList) {
                if (course.getCode().equals(data.get(0).getText())) {
                    course.setLecturer(data.get(2).getText());
                }
            }
            l++;
        }

        for (Temp_JustAllCourses temp : arrayList) {
            System.out.println(temp.printDetails());
        }
    }

}



package network.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Test7_RunningTable {
    private static final int MAT_NUMBER = 1234_5678;
    private static final String THIS_SEMESTER = "2018/2019 Second Semester";
    private static FirefoxDriver driver;
    private static WebDriverWait loadWaiter;
    private static ArrayList<Temp_RunningCourse> arrayList = new ArrayList<>();


    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);

        driver.navigate().to("https://www.utg.gm/login");
        //if no internetconnection, return because not detected by this!

        WebElement usernameElement = driver.findElement(By.name("email"));
        usernameElement.sendKeys(MAT_NUMBER+"@utg.edu.gm");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(Integer.toString(MAT_NUMBER));

        WebElement formElement = driver.findElement(By.className("form-group"));
        formElement.submit();

        loadWaiter = new WebDriverWait(driver, 5);//should be more?
        try{
            loadWaiter.until(ExpectedConditions.presenceOfElementLocated(By.className("media-heading")));
            driver.navigate().to("https://www.utg.gm/course-registrations");
            loadWaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("table")));

            tableOnSight();
        }catch (TimeoutException t){//... time ran out!
            JOptionPane.showMessageDialog(null,"Process Timed-Out! Please Check Your Internet Connection And Try Again...");
            driver.quit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
            driver.quit();
        }


    }

    private static void tableOnSight(){
        List<WebElement> tabs = loadWaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".nav-tabs > li")));
        //that gives the tabs: right from 'main menu' 'check mail' 'logout' .....to 'payment'
//        loadWaiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-line > li.active > a, .nav-line > li.active > a:hover, .nav-line > li.active > a:focus"))).click();
        tabs.get(4).click();
        System.out.println(tabs.get(4).getText());

        WebElement allCourseTable = driver.findElementByCssSelector(".table-warning");
        for(WebElement t : allCourseTable.findElements(By.tagName("th"))){
            System.out.print(t.getText()+"\t");
        }

        WebElement tableBody = allCourseTable.findElement(By.tagName("tbody"));

        List<WebElement> captions = tableBody.findElements(By.cssSelector("b, strong"));
        boolean pass = captions.get(captions.size()-1).getText().equalsIgnoreCase(THIS_SEMESTER);
        if (pass) {
            System.out.println("\n"+pass);
        }else {
            JOptionPane.showMessageDialog(null,"Student does not yet register for this semester");
            driver.quit();
            return;
        }

        List<WebElement> allRows = tableBody.findElements(By.tagName("tr"));
        System.out.println("\n//"+allRows.size());

        //let the scrapping begin!
        int match = allRows.size() -1;
        while (!allRows.get(match).getText().equals(THIS_SEMESTER)){
            final List<WebElement> data = allRows.get(match).findElements(By.tagName("td"));
            arrayList.add(new Temp_RunningCourse(data.get(0).getText(),data.get(1).getText(),data.get(2).getText(),data.get(4).getText()));
            match--;
        }

        JOptionPane.showMessageDialog(null,arrayList.size()+" registered courses found");
        for (Temp_RunningCourse t : arrayList){
            System.out.println(t.getDetails());
        }
    }

}

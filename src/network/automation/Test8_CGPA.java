package network.automation;

import io.InternetAvailabilityChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Test8_CGPA {
    private static final int MAT_NUMBER = 1234_5678;
    private static FirefoxDriver driver;
    private static WebDriverWait loadWaiter;
    private static ArrayList<Temp_JustAllCourses> arrayList = new ArrayList<>();


    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();

        if (!InternetAvailabilityChecker.isInternetAvailable()) {
            JOptionPane.showMessageDialog(null,"Please check your internet Connection and try again","No Internet",JOptionPane.ERROR_MESSAGE);
            driver.quit();
            return;
        }

        driver.navigate().to("https://www.utg.gm/login");

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
        }catch (TimeoutException t){//... time ran out
            JOptionPane.showMessageDialog(null,"Process Timed-Out! Please Check Your Internet Connection And Try Again...");
            driver.quit();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
            driver.quit();
        }

    }

    private static void tableOnSight(){
        List<WebElement> tabs = loadWaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".nav-tabs > li")));
        tabs.get(7).click();
        System.out.println(tabs.get(7).getText());

        WebElement surrounder = driver.findElementsByCssSelector(".pull-right").get(3);
        WebElement cgpa = surrounder.findElements(By.tagName("th")).get(1);

//        System.out.println(cgpa.getText());
        JOptionPane.showMessageDialog(null,"Your Current CGPA is "+cgpa.getText(),"CGPA Report",JOptionPane.PLAIN_MESSAGE);
    }

}


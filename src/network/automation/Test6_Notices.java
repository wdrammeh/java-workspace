package network.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class Test6_Notices {


    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","geckodriver");
        FirefoxDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.utg.gm/login");

        WebElement usernameElement = driver.findElement(By.name("email"));
        usernameElement.sendKeys("21712494@utg.edu.gm");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("21712494");

        WebElement formElement = driver.findElement(By.className("form-group"));
        formElement.submit();

        WebDriverWait wait = new WebDriverWait(driver, 59);

        try {

            WebElement admissionAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("gritter-title")));
//            System.out.println(admissionAlert.getText());
            JOptionPane.showMessageDialog(null,admissionAlert.getText());
        }catch (Exception e){

        }

        //-----------------------------------------------------------
        driver.navigate().to("https://www.utg.gm/course-registrations/");
        WebElement registrationNotice = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("gritter-title")));
//        System.out.println(registrationNotice.getText());
        JOptionPane.showMessageDialog(null,registrationNotice.getText());

        driver.quit();
    }
}

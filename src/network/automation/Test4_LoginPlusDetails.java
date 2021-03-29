package network.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class Test4_LoginPlusDetails {
    private static String email = "21712494@utg.edu.gm";
    private static String password = "21712494";
    private static FirefoxDriver driver;
    private static String name,major,program,emil,fn,ln,school,address,tel,mStatus,dob,nationality,dept;
    private static int moa;
    private static int yoa;
    private static String mat;

    private static String os, level, levNum, status;

    public static void main(String[] args) {
        try{
            System.setProperty("webdriver.gecko.driver", "linuxdriver.run");

            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);

            driver = new FirefoxDriver(options);
            driver = new FirefoxDriver();
            driver.get("https://www.utg.gm/login");
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.className("form-group")).submit();

            //no internet to be caught right here!

            WebDriverWait tWaiter = new WebDriverWait(driver, 5);//should be more?
            try {
                WebElement danger = tWaiter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-danger")));
                JOptionPane.showMessageDialog(null,"The Information Provided Do Not Match Any Student\nPlease Try Again",danger.getText().split("\n")[1],JOptionPane.ERROR_MESSAGE);
                driver.quit();
                return;
            }catch (TimeoutException out){//if the time is up yet there's no danger sign, 1 condition?
                //1. Let the next instantiation wait for the name element, throw timeout, otherwise proceed

            }catch (Exception others){
                driver.quit();
                JOptionPane.showMessageDialog(null,others.getLocalizedMessage());
                return;
            }

            WebDriverWait loadWaiter = new WebDriverWait(driver, 59);//should be more?
            try{
                name = loadWaiter.until(ExpectedConditions.presenceOfElementLocated(By.className("media-heading"))).getText();
                if (JOptionPane.showConfirmDialog(null, "Successfully Found "+name+"\nContinue?", "Confirm It's You", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                    onPortal(name);
                } else {
                    driver.quit();
                }
            }catch (TimeoutException t){//... time ran out
                JOptionPane.showMessageDialog(null,"Process Timed-Out! Please Check Your Internet Connection And Try Again...");
                driver.quit();
            }catch (NullPointerException noll){
                JOptionPane.showMessageDialog(null,"Warning, Dashboard could not find details as expected!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
                driver.quit();
            }
        }catch (NoSuchSessionException se){
//            System.err.println(se.getLocalizedMessage());
            se.printStackTrace();
        }catch (WebDriverException wo){//connectionless-initialization plus
//            System.err.println(wo.getLocalizedMessage());
            wo.printStackTrace();
        }


    }


    private static void onPortal(String portalName) throws NullPointerException{//in dashboard the propeler type is no needed!
        //here, set details
        driver.navigate().to("https://www.utg.gm/course-registrations/");



        //please wait....
        final String[] allNames = portalName.split(" ");
        fn = allNames[allNames.length-1];
        ln = allNames[0] + (allNames.length == 3 ? " "+allNames[1] : "");

        final List<WebElement> iGroup = driver.findElementsByClassName("info-group");

        level = iGroup.get(2).getText().split("\n")[1];
        status = iGroup.get(3).getText().split("\n")[1];

        final String[] findingSemester = iGroup.get(6).getText().split("\n")[0].split(" ");
        os = findingSemester[0]+" "+findingSemester[1]+" "+findingSemester[2];

        school = iGroup.get(1).getText().split("\n")[1];

        program = driver.findElementByXPath("/html/body/section/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/h4").getText();

        driver.navigate().to("https://www.utg.gm/profile/");
        final List<WebElement> detail = driver.findElementsByClassName("info-group");
        try{
            mat = driver.findElementByCssSelector("b, strong").getText().split(" ")[1];
            address = detail.get(0).getText().split("\n")[1];
            emil = detail.get(1).getText().split("\n")[1];
            tel = detail.get(2).getText().split("\n")[1];
            mStatus = detail.get(3).getText().split("\n")[1];
            dob = detail.get(4).getText().split("\n")[1];
            nationality = detail.get(5).getText().split("\n")[1];
            dept = detail.get(7).getText().split("\n")[1];
            major = detail.get(8).getText().split("\n")[1].split(" ")[4];

            //regulating the year of  admission
            final String[] admissionDate = detail.get(6).getText().split("\n");
            yoa = Integer.valueOf(admissionDate[1].split("-")[0]);
            moa = Integer.valueOf(admissionDate[1].split("-")[1]);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Warning, Dashboard does not find details as expected!");
        }

        printOut();
    }

    private static void printOut(){
        System.out.println("OngoingSemester = "+os);
        System.out.println("Level = "+level);
        System.out.println("Status = "+status);
        System.out.println("LevelNumber = "+levNum+"\n");

        System.out.println("FirstName = "+fn);
        System.out.println("LastName = "+ln);
        System.out.println("mat# = "+mat);
        System.out.println("Program = "+program);
        System.out.println("School = "+school);
        System.out.println("Department = "+dept);
        System.out.println("Nationality = "+nationality);
        System.out.println("Major = "+major);
        System.out.println("Minor = ");
        System.out.println("DOB = "+dob);
        System.out.println("MOA = "+moa);
        System.out.println("YOA = "+yoa);
        System.out.println("Expected To Grad = ");
        System.out.println("Place OB = ");
        System.out.println("Address = "+address);
        System.out.println("Marital Status = "+mStatus);
        System.out.println("Tel = "+tel);
        System.out.println("Email = "+emil);

    }

}

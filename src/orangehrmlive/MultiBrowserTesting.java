package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTesting {
    //declare global variable//
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;
    //declare main method//
    public static void main(String[] args) {
        //declare scanner for input//
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter browser name : ");
        String browser = scanner.next();
        scanner.close();
       //try and catch block define for catching exception//
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");//open in firefox//
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.msedge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("wrong browser");
            }
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Title of the page : " + driver.getTitle());
            //print the current URL//
            System.out.println( " Current URL : "  + driver.getCurrentUrl());
            //print the page source//
            System.out.println("Page source  : "  + driver.getPageSource());
            //enter username into the  field //
            WebElement userField = driver.findElement(By.name("username"));
            userField.sendKeys("siddhi.munim@gmail.com");
            //enter password to password field//
            WebElement passwordField =driver.findElement(By.name("password"));
            passwordField.sendKeys("123test");


        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
           // System.out.println("Exception happend");


        }
        //driver.quit();
    }
}

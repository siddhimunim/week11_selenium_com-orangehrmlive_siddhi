package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxTesting {
    //declare main method//
    public static void main(String[] args) {

        String baseUrl ="https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //launch the URL//
        driver.get(baseUrl);
        //maximize window//
        driver.manage().window().maximize();
        //we give implicit time to driver//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        //print title of the page//
        System.out.println("Title of the page : " + driver.getTitle());
        //print the current URL//
        System.out.println("Current URl : " + driver.getCurrentUrl());
        //print the page course//
        System.out.println("Page source : " + driver.getPageSource());
        //enter username into field//
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        //password field//
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //close the browser//
        driver.quit();



    }

}

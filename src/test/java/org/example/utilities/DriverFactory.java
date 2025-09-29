package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory(){}

    public static WebDriver getDriver(){

        if(driver==null){
            ChromeOptions options  = new ChromeOptions();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));


        }
        return driver;

    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }


    }
}







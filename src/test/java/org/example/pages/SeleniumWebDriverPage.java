package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWebDriverPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public final By seleniumLink = By.cssSelector("a[href='#Selenium_WebDriver']");


    public SeleniumWebDriverPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String pageTitle(){
        return driver.getTitle();
    }

    public void getAndPrintCurrentUrl(){
       String currentUrl  = driver.getCurrentUrl();

        System.out.println("url"+ currentUrl);
    }


    public boolean containString(){
        String currentUrl  = driver.getCurrentUrl().toLowerCase().replace("_", "-");
        return currentUrl.contains("selenium-webdriver");

    }



    public void openSeleniumWebDriverSection(){
        wait.until(ExpectedConditions.elementToBeClickable(seleniumLink)).click();
    }

}

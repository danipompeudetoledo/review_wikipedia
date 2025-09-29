package org.example.pages;

import org.example.locators.WikiLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikipediaHomePage {

   private final  WebDriver driver;
   private final  WebDriverWait wait;

    @FindBy(css = WikiLocators.SEARCH_INPUT_CSS)
    private WebElement searchInput;


    public WikipediaHomePage(WebDriver driver){
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(){
        driver.get(WikiLocators.HOME_URL);

    }

    public void typesearch(String query){
        searchInput.clear();
        searchInput.sendKeys(query);

    }

    public boolean waitForSuggestions(Duration timeout) {

        try {


            new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.presenceOfElementLocated(WikiLocators.SUGGESTION_DROPDOWN_ANY));
            return true;


        } catch (TimeoutException e) {
            return false;
        }
    }
        public void pickFirstSuggestionOrEnter (){
            List<WebElement> options = driver.findElements(WikiLocators.FIRST_SUGGESTION_ANY);
            if (!options.isEmpty()) {
                options.get(0).click();
            } else {
                searchInput.sendKeys(Keys.ENTER);
            }
        }
    }













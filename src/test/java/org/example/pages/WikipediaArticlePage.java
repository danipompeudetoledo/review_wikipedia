package org.example.pages;

import org.example.locators.WikiLocators;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WikipediaArticlePage {

   private final WebDriver driver;
   private final WebDriverWait wait;


    @FindBy(css = WikiLocators.ARTICLE_TITLE_CSS)
    private WebElement articleTitle;

    //@FindBy(css = WikiLocators.TOC_CSS)
    //private WebElement toc;

    public WikipediaArticlePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void waitForArticle() {
        wait.until(ExpectedConditions.visibilityOf(articleTitle));
    }

    public String getArticleTitle(){
        return articleTitle.getText();
    }

    /** Tenta clicar no link "References" dentro do TOC. Retorna true se clicou, false se ausente. */
    public boolean clickReferences() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(WikiLocators.TOC_ANY));

            List<WebElement> links = driver.findElements(WikiLocators.TOC_REFERENCES_LINK);
            if (!links.isEmpty()) {
                links.get(0).click();
                return true;
            } else {
                System.out.println("TOC presente, mas sem link 'References'.");
                return false;
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("This article has no table of contents, or it's not showing");
            return false;
        }
    }

    /** Imprime e retorna se a URL atual contém '#References' (case-insensitive). */
    public boolean isAtReferences(){
        String url = driver.getCurrentUrl();
        boolean ok = url.toLowerCase().contains("#references");
        System.out.println("URL contains '#references'?" + ok + "->" + url);
        return ok;

    }











}

package org.example.tests;

import org.example.base.Basetest;
import org.example.pages.WikipediaArticlePage;
import org.example.pages.WikipediaHomePage;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class test extends Basetest {
    @Test
    void FlowTest (){


        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        WikipediaArticlePage page = new WikipediaArticlePage(driver);

        // open wikipedia home page
        homePage.openHomePage();

        // search"Laptop"

        homePage.typesearch("Laptop");

        boolean hasDropdown = homePage.waitForSuggestions(Duration.ofSeconds(5));
        if(!hasDropdown){
            System.out.println("Dropdown has not shown. Using ENTER as fallback");
        }
        homePage.pickFirstSuggestionOrEnter();

        // 4) Na página do artigo: esperar, ler título, clicar References
        page.waitForArticle();
        System.out.println("Article title" + page.getArticleTitle());


        boolean clicked = page.clickReferences();
        if (!clicked) {
            System.out.println("It can't possible click on references");
        }


        // 5) Verificar (imprimir) se URL contém #References
        page.isAtReferences();

        // 6) Browser fecha no @AfterEach (BaseTest)


    }






}


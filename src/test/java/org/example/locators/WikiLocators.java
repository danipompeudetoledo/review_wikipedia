package org.example.locators;

import org.openqa.selenium.By;

public final class WikiLocators {
    private WikiLocators(){}

    // URLs
    public static final String HOME_URL = "https://en.wikipedia.org/";

    // PageFactory-friendly (strings)
    public static final String SEARCH_INPUT_CSS   = "input#searchInput";
    public static final String ARTICLE_TITLE_CSS  = "#firstHeading";
    public static final String TOC_CSS            = "#toc";

    // Dinâmicos / fallback (By)
    // Wikipedia muda o HTML do typeahead com certa frequência, então usamos seletores "largos"
    public static final By SUGGESTION_DROPDOWN_ANY = By.cssSelector(
            ".mw-searchSuggest-popup, .suggestions-dropdown, .cdx-typeahead-menu, .cdx-menu"
    );
    public static final By FIRST_SUGGESTION_ANY = By.cssSelector(
            ".mw-searchSuggest-link, .cdx-menu a[href], .suggestions-dropdown a[href]"
    );

    // Container TOC (aceita #toc ou qualquer coisa com class='toc')
    public static final By TOC_ANY = By.xpath("//*[@id='toc' or contains(@class,'toc')]");

    // Link References dentro do TOC (mais flexível)
    public static final By TOC_REFERENCES_LINK = By.xpath(
            "//*[@id='toc' or contains(@class,'toc')]//a[contains(@href,'#References') or normalize-space()='References']"
    );

}

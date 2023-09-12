package org.ui.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CatalogPageSteps {

    private static CatalogPageSteps catalogPageSteps;
    private WebDriver driver;
    private Actions action;

    private CatalogPageSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static CatalogPageSteps getInstance(WebDriver driver) {
        if (catalogPageSteps == null) {
            catalogPageSteps = new CatalogPageSteps(driver);
        }
        return catalogPageSteps;
    }

    @FindBy(xpath = ".//*[@id='data-testid']")
    ItemSteps item;
}

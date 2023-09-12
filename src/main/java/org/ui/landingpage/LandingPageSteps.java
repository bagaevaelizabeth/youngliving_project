package org.ui.landingpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ui.catalog.CatalogPageSteps;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LandingPageSteps {

    private static LandingPageSteps landingPageSteps;
    private WebDriver driver;

    private LandingPageSteps(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public static LandingPageSteps getInstance(WebDriver driver) {
        if (landingPageSteps == null) {
            landingPageSteps = new LandingPageSteps(driver);
        }
        return landingPageSteps;
    }

    @FindBy(xpath = "//*[contains(@class,'position-static header-left')]")
    HeaderLeftSectionSteps headerLeftSection;

    @FindBy(xpath = "//*[contains(@class,'main-catalog-page')]")
    CatalogPageSteps catalogSection;

}

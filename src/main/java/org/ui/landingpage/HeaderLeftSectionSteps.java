package org.ui.landingpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HeaderLeftSectionSteps {

    private static HeaderLeftSectionSteps headerMenuSteps;
    private WebDriver driver;
    private Actions action;

    private HeaderLeftSectionSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static HeaderLeftSectionSteps getInstance(WebDriver driver) {
        if (headerMenuSteps == null) {
            headerMenuSteps = new HeaderLeftSectionSteps(driver);
        }
        return headerMenuSteps;
    }

    @FindBy(xpath = ".//*[@data-testid='qa-myaccount']")
    WebElement signInButton;

    @FindBy(xpath = ".//*[@data-testid='qa-search-input']")
    WebElement searchInput;

    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    WebElement spinner;

    // I need to think how to wait when spinner will disappear
    public HeaderLeftSectionSteps waitPageLoading() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public HeaderLeftSectionSteps clickSignInButton() {
        signInButton.click();
        return this;
    }

    public HeaderLeftSectionSteps sendSearchInput(String value) {
        searchInput.isDisplayed();
        searchInput.sendKeys(value);
        action.sendKeys(Keys.ENTER);
        return this;
    }
}

package org.ui.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ItemSteps {

    private static ItemSteps itemSteps;
    private WebDriver driver;
    private Actions action;

    private ItemSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static ItemSteps getInstance(WebDriver driver) {
        if (itemSteps == null) {
            itemSteps = new ItemSteps(driver);
        }
        return itemSteps;
    }

    // It's not a good decision. I have to think about a possibility to choose an item by name
    // like "Everyday Oils Essential Oil Collection"
    @FindBy(xpath = ".//*[@data-testid='qa-quick-shop'][1]")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    WebElement spinner;

    public ItemSteps waitPageLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public ItemSteps clickAddToCartButton() {
        addToCartButton.isDisplayed();
        addToCartButton.click();
        return this;
    }
}

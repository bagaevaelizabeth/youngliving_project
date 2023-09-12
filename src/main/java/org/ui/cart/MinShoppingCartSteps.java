package org.ui.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MinShoppingCartSteps {

    private static MinShoppingCartSteps minShoppingCartSteps;
    private WebDriver driver;
    private Actions action;

    private MinShoppingCartSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static MinShoppingCartSteps getInstance(WebDriver driver) {
        if (minShoppingCartSteps == null) {
            minShoppingCartSteps = new MinShoppingCartSteps(driver);
        }
        return minShoppingCartSteps;
    }

    @FindBy(xpath = "//button[contains(@class,'view-cart-button')]")
    WebElement viewCartButton;

    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    WebElement spinner;

    // I need to think how to wait when spinner will disappear
    public MinShoppingCartSteps waitPageLoading() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public MinShoppingCartSteps clickViewCart() {
        viewCartButton.isDisplayed();
        viewCartButton.click();
        return this;
    }
}

package org.ui.cart;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ShoppingCartSteps {

    private static ShoppingCartSteps orderSummarySteps;
    private WebDriver driver;
    private Actions action;

    private ShoppingCartSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static ShoppingCartSteps getInstance(WebDriver driver) {
        if (orderSummarySteps == null) {
            orderSummarySteps = new ShoppingCartSteps(driver);
        }
        return orderSummarySteps;
    }

    @FindBy(xpath = "//[@data-testid='qa-cart-checkout']")
    WebElement checkOutButton;

    @FindBy(xpath = "//*[@data-testid='qa-products-container']//*[contains(@class, 'cart-product-name')]//*[1]")
    WebElement iteName;

    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    WebElement spinner;

    // I need to think how to wait when spinner will disappear
    public ShoppingCartSteps waitPageLoading() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public ShoppingCartSteps clickCheckOut() {
        checkOutButton.isDisplayed();
        checkOutButton.click();
        return this;
    }

    public ShoppingCartSteps checkItemName(String expectedName) {
        iteName.isDisplayed();
        String actualName = iteName.getText();
        Assertions.assertThat(actualName).isEqualTo(expectedName);
        return this;
    }
}

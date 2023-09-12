package org.ui.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutShippingSectionSteps {

    private static CheckOutShippingSectionSteps checkOutShippingSectionSteps;
    private WebDriver driver;
    private Actions action;

    private CheckOutShippingSectionSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static CheckOutShippingSectionSteps getInstance(WebDriver driver) {
        if (checkOutShippingSectionSteps == null) {
            checkOutShippingSectionSteps = new CheckOutShippingSectionSteps(driver);
        }
        return checkOutShippingSectionSteps;
    }

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='addressLine1']")
    WebElement addressLine1Input;

    @FindBy(xpath = "//*[@id='city']")
    WebElement cityInput;

    @FindBy(xpath = "//*[@id='qa-state']")
    Select stateDropDown;

    @FindBy(xpath = "//*[@id='zip']")
    WebElement zipInput;

    @FindBy(xpath = "//*[@data-testid='qa-ship-continue']")
    WebElement continueButton;

    public CheckOutShippingSectionSteps sendFirstName(String value) {
        firstNameInput.isDisplayed();
        firstNameInput.sendKeys(value);
        return this;
    }

    public CheckOutShippingSectionSteps sendLastName(String value) {
        lastNameInput.isDisplayed();
        lastNameInput.sendKeys(value);
        return this;
    }

    public CheckOutShippingSectionSteps sendAddress(String value) {
        addressLine1Input.isDisplayed();
        addressLine1Input.sendKeys(value);
        return this;
    }

    public CheckOutShippingSectionSteps sendCity(String value) {
        cityInput.isDisplayed();
        cityInput.sendKeys(value);
        return this;
    }

    public CheckOutShippingSectionSteps selectState(String value) {
        stateDropDown.selectByVisibleText(value);
        return this;
    }

    public CheckOutShippingSectionSteps sendZip(String value) {
        zipInput.isDisplayed();
        zipInput.sendKeys(value);
        return this;
    }

    public CheckOutShippingSectionSteps clickContinue() {
        continueButton.isDisplayed();
        continueButton.click();
        return this;
    }
}

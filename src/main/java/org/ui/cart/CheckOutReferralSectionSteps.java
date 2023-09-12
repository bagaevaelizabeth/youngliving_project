package org.ui.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutReferralSectionSteps {

    private static CheckOutReferralSectionSteps checkOutLeftSectionSteps;
    private WebDriver driver;
    private Actions action;

    private CheckOutReferralSectionSteps(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public static CheckOutReferralSectionSteps getInstance(WebDriver driver) {
        if (checkOutLeftSectionSteps == null) {
            checkOutLeftSectionSteps = new CheckOutReferralSectionSteps(driver);
        }
        return checkOutLeftSectionSteps;
    }

    @FindBy(xpath = "//*[@data-testid='qa-referral-code-continue']")
    WebElement continueButton;

    //I added this button to this class because I don't want to describe the modal element.
    @FindBy(xpath = "//*[@data-testid = 'qa-confirm-yes']")
    WebElement continueWithoutReferral;

    public CheckOutReferralSectionSteps clickContinue() {
        continueButton.isDisplayed();
        continueButton.click();
        return this;
    }

    public CheckOutReferralSectionSteps clickContinueWithoutReferral() {
        continueWithoutReferral.isDisplayed();
        continueWithoutReferral.click();
        return this;
    }
}

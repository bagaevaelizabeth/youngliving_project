package org.ui.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginFormSteps {

    private static LoginFormSteps loginFormSteps;
    private WebDriver driver;

    private LoginFormSteps(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public static LoginFormSteps getInstance(WebDriver driver) {
        if (loginFormSteps == null) {
            loginFormSteps = new LoginFormSteps(driver);
        }
        return loginFormSteps;
    }

    @FindBy(xpath = "//*[@id='loginUsername']")
    WebElement loginInput;

    @FindBy(xpath = "//*[@id='continue-btn']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id = 'loginPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-btn']")
    WebElement signInButton;

    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    WebElement spinner;

    // I need to think how to wait when spinner will disappear
    public LoginFormSteps waitPageLoading() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(spinner));
        return this;
    }

    public LoginFormSteps sendLogin(String login) {
        loginInput.isDisplayed();
        loginInput.sendKeys(login);
        return this;
    }

    public LoginFormSteps sendPassword(String password) {
        passwordInput.isDisplayed();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginFormSteps clickSignIn() {
        signInButton.isDisplayed();
        signInButton.click();
        return this;
    }

    public LoginFormSteps clickContinue() {
        continueButton.isDisplayed();
        continueButton.click();
        return this;
    }

}

package landingpage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ui.cart.MinShoppingCartSteps;
import org.ui.cart.ShoppingCartSteps;
import org.ui.catalog.ItemSteps;
import org.ui.landingpage.HeaderLeftSectionSteps;
import org.ui.login.LoginFormSteps;

import static utils.ConfProperties.getProperty;

public class BaseCartTest extends BaseTest {

    public static final String ITEM_NAME = "Oil";
    private HeaderLeftSectionSteps headerLeftSectionSteps;
    private LoginFormSteps loginFormSteps;
    private ItemSteps itemSteps;
    private MinShoppingCartSteps minShoppingCartSteps;
    private ShoppingCartSteps shoppingCartSteps;

    @BeforeEach
    public void prepareData() {
        headerLeftSectionSteps = HeaderLeftSectionSteps.getInstance(webDriver);
        loginFormSteps = LoginFormSteps.getInstance(webDriver);
        itemSteps = ItemSteps.getInstance(webDriver);
        minShoppingCartSteps = MinShoppingCartSteps.getInstance(webDriver);
        shoppingCartSteps = ShoppingCartSteps.getInstance(webDriver);
        webDriver.get(getProperty("landingPage"));
    }

    @Test
    public void checkMenuSolutionIsDisplayed() throws InterruptedException {
        String expectedItemName = "Everyday Oils Essential Oil Collection";
        headerLeftSectionSteps
                .clickSignInButton();
        loginFormSteps
                .sendLogin(getProperty("login"))
                .clickContinue()
                .waitPageLoading()
                .sendPassword(getProperty("password"))
                .clickSignIn();
        headerLeftSectionSteps
                .waitPageLoading()
                .sendSearchInput(ITEM_NAME);
        itemSteps
                .waitPageLoading()
                .clickAddToCartButton();
        minShoppingCartSteps
                .waitPageLoading()
                .clickViewCart();
        shoppingCartSteps
                .waitPageLoading()
                .checkItemName(expectedItemName);
    }
}

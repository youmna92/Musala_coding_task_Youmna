package testClasses;

import BasePackage.BaseTest;
import Pages.cartPage;
import Pages.checkoutPage;
import Pages.overviewPage;
import Pages.productsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkoutTest extends BaseTest {

    public static cartPage cartPageObject;
    public static checkoutPage checkoutPageObject;
    public static overviewPage overviewPageObject;

    @BeforeClass
    public void initialization(){
        cartPageObject = new cartPage();
        checkoutPageObject = new checkoutPage();
        overviewPageObject = new overviewPage();
    }

    @Test (priority = 0)
    public void clickCheckout(){
        cartPageObject.clickCheckout();
        String pageTitle = checkoutPageObject.getPageTitle();
        Assert.assertEquals(pageTitle,"CHECKOUT: YOUR INFORMATION");
    }

    @Test (priority = 1)
    public void fillCheckoutInfo(){

        checkoutPageObject.enterFirstName();
        checkoutPageObject.enterLastName();
        checkoutPageObject.enterPostCode();
        checkoutPageObject.clickContinue();
        String title = overviewPageObject.getPageTitle();
        Assert.assertEquals(title,"CHECKOUT: OVERVIEW");
    }

    @Test (priority = 2)
    public void finishCheckout(){

        overviewPageObject.clickFinish();
        String completeMessage = overviewPageObject.getCompleteHeader();
        Assert.assertEquals(completeMessage,"THANK YOU FOR YOUR ORDER");
    }

}

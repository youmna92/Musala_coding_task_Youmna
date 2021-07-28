package testClasses;

import BasePackage.BaseTest;
import Pages.loginPage;
import Pages.productsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    public static loginPage loginPageObject;
    public static productsPage productsPageObject;

    @BeforeClass
    public void initialization(){
        loginPageObject = new loginPage();
        productsPageObject = new productsPage();
    }

    @Test
    public void LoginToHomePage(){
        loginPageObject.enterUsername();
        loginPageObject.enterPassword();
        loginPageObject.clickLogin();
        String pageTitle = productsPageObject.getProductsPageTitle();
        Assert.assertEquals(pageTitle,"PRODUCTS");
    }


}

package testClasses;

import BasePackage.BaseTest;
import Pages.cartPage;
import Pages.productsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addToCartTest extends BaseTest {

    public static productsPage productsPageObject;
    public static cartPage cartPageObject;
    public static String itemName=null;

    @BeforeClass
    public void initialization(){
        productsPageObject = new productsPage();
        cartPageObject = new cartPage();
    }

    @Test (priority = 0)
    public void addToCart() throws InterruptedException {

        itemName = productsPageObject.addFirstItemToCart();
        productsPageObject.clickOnCart();
    }

    @Test (priority = 1)
    public void checkItemTitleInCart(){

        String cartItemName = cartPageObject.getCartItemName();
        int cartItemNumber = cartPageObject.getCartItemNumbers();
        Assert.assertEquals(cartItemNumber,1);
        Assert.assertEquals(cartItemName,itemName);
    }
}

package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class cartPage extends BasePage {

    public String getCartItemName(){

        WebElement cartItemName = driver.findElement(By.className("inventory_item_name"));
        String itemName = cartItemName.getText();

        return itemName;
    }

    public int getCartItemNumbers(){

        WebElement cartItemsNumber = driver.findElement(By.className("cart_quantity"));
        String itemsNumberString = cartItemsNumber.getText();
        int itemsNumber = Integer.parseInt(itemsNumberString);

        return itemsNumber;
    }

    public void clickCheckout(){

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        elementClick(checkoutButton);

    }

}

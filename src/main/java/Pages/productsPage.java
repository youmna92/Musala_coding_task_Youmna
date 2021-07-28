package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BasePackage.BaseTest.driver;

import java.util.List;

public class productsPage extends BasePage {

    public String addFirstItemToCart() throws InterruptedException {

        List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
        WebElement firstItem = allItems.get(0);
        String itemName = firstItem.findElement(By.className("inventory_item_name")).getText();
        int numberOfItems = allItems.size();
        System.out.println("number of items is: "+numberOfItems);
        System.out.println("Item's Name is: "+itemName);
        WebElement addToCartButton = firstItem.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        elementClick(addToCartButton);
        //Thread.sleep(5000);

        return itemName;
    }


    public void clickOnCart(){

        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        elementClick(cart);
    }

    public String getProductsPageTitle(){

        WebElement pageTitle = driver.findElement(By.className("title"));
        String title = pageTitle.getText();

        return title;
    }

}

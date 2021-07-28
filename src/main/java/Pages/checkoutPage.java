package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BasePackage.BaseTest.driver;

public class checkoutPage extends BasePage {

    public String getPageTitle(){

        WebElement pageTitle = driver.findElement(By.className("title"));
        String title = pageTitle.getText();

        return title;
    }

    public void enterFirstName(){

        WebElement firstName = driver.findElement(By.id("first-name"));
        elementSendKeys(firstName,"Youmna");

    }

    public void enterLastName(){

        WebElement lastName = driver.findElement(By.id("last-name"));
        elementSendKeys(lastName,"Zakarya");
    }

    public void enterPostCode(){

        WebElement postCode = driver.findElement(By.id("postal-code"));
        elementSendKeys(postCode,"00202");
    }

    public void clickContinue(){

        WebElement continueButton = driver.findElement(By.id("continue"));
        elementClick(continueButton);
    }
}

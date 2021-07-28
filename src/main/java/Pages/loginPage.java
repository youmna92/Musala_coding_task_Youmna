package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class loginPage extends BasePage {

    public void enterUsername (){

        WebElement usernameField = driver.findElement(By.id("user-name"));
        elementSendKeys(usernameField,"standard_user");
    }

    public void enterPassword (){

        WebElement usernameField = driver.findElement(By.id("password"));
        elementSendKeys(usernameField,"secret_sauce");
    }

    public void clickLogin(){

        WebElement loginButton = driver.findElement(By.id("login-button"));
        elementClick(loginButton);
    }

}

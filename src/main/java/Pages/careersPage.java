package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BasePackage.BaseTest.driver;

public class careersPage extends BasePage {


    public void clickCheckOpenPositions(){

        WebElement openPositions = driver.findElement(By.xpath("//span[@data-alt='Check our open positions']"));
        elementClick(openPositions);
    }


}

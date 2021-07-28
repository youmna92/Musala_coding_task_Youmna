package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BasePackage.BaseTest.driver;

public class overviewPage extends BasePage {

    public String getPageTitle(){

        WebElement pageTitle = driver.findElement(By.className("title"));
        String title = pageTitle.getText();

        return title;
    }

    public void clickFinish(){

        WebElement finishButton = driver.findElement(By.id("finish"));
        elementClick(finishButton);
    }

    public String getCompleteHeader(){

        WebElement completeHeader = driver.findElement(By.className("complete-header"));
        String completeHeaderText = completeHeader.getText();

        return completeHeaderText;
    }

}

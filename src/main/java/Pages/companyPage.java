package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class companyPage extends BasePage {


    public boolean leaderSectionVisible() throws InterruptedException {
        boolean flag;
        WebElement leaders = driver.findElement(By.xpath("//section[@class='company-members']"));
        flag = leaders.isDisplayed();
        return flag;
    }

    public void clickFacebookLink(){

        WebElement fbLink = driver.findElement(By.xpath("//span[@class='musala musala-icon-facebook']"));
        elementClick(fbLink);
    }

    public boolean fbLogoVisible() throws InterruptedException {
        boolean flag;
        WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Profile picture']"));
        flag = logo.isDisplayed();
        return flag;
    }


}

package Pages;

import BasePackage.BasePage;
import Utilities.ExcelUtils;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static BasePackage.BaseTest.driver;

public class homePage extends BasePage {


    public void clickContactUs(){

        WebElement contactUsButton = driver.findElement(By.xpath("//span[@data-alt='Contact us']"));
        elementClick(contactUsButton);
    }

    public void fillContactName(String iteration) throws FilloException {

        WebElement nameField = driver.findElement(By.xpath("//input[@name='your-name']"));
        String name = ExcelUtils.SelectCell("Select * from TestCase1 where Test_iteration='"+iteration+"'","Name");
        elementSendKeys(nameField,name);
    }

    public void fillContactEmail(String iteration) throws FilloException {

        WebElement emailField = driver.findElement(By.xpath("//input[@name='your-email']"));
        String email = ExcelUtils.SelectCell("Select * from TestCase1 where Test_iteration='"+iteration+"'","Email");
        elementSendKeys(emailField,email);
    }

    public void fillContactMobile(String iteration) throws FilloException {

        WebElement mobileField = driver.findElement(By.xpath("//input[@name='mobile-number']"));
        String mobile = ExcelUtils.SelectCell("Select * from TestCase1 where Test_iteration='"+iteration+"'","Mobile");
        elementSendKeys(mobileField,mobile);
    }


    public void fillContactSubject(String iteration) throws FilloException {

        WebElement subjectField = driver.findElement(By.xpath("//input[@name='your-subject']"));
        String subject = ExcelUtils.SelectCell("Select * from TestCase1 where Test_iteration='"+iteration+"'","Subject");
        elementSendKeys(subjectField,subject);
    }

    public void fillContactMessage(String iteration) throws FilloException {

        WebElement messageField = driver.findElement(By.xpath("//textarea[@name='your-message']"));
        String message = ExcelUtils.SelectCell("Select * from TestCase1 where Test_iteration='"+iteration+"'","Message");
        elementSendKeys(messageField,message);
    }

//    public void checkCaptcha(){
//
//        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//        WebElement iFrame_checkbox = driver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark"));
//        elementHoverOver(iFrame_checkbox);
//        ClickByAction(iFrame_checkbox);
//        driver.switchTo().defaultContent();
//    }

    public void closeContactUs(){

        WebElement close = driver.findElement(By.xpath("//a[@id='fancybox-close']"));
        elementClick(close);
    }

    public void clickSubmit(){

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        elementClick(submit);
    }

    public String emailIncorrectError(){

        WebElement error = driver.findElement(By.xpath("//span[@class='wpcf7-not-valid-tip']"));
        String message = error.getText();
        return message;
    }

    public void clickCompanyLink(){

        WebElement company = driver.findElement(By.xpath("//div[@id='menu']//a[normalize-space()='Company']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(company));
        elementClick(company);
    }

    public void clickCareersLink(){

        WebElement careers = driver.findElement(By.xpath("//ul[@id='menu-main-nav-1']//a[normalize-space()='Careers']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(careers));
        elementClick(careers);
    }


}

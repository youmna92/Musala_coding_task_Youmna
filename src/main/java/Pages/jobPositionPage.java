package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BasePackage.BaseTest.driver;

public class jobPositionPage extends BasePage {

    public boolean generalDescriptionVisible() throws InterruptedException {
        boolean flag;
        WebElement GenDescElem = driver.findElement(By.xpath("//h2[normalize-space()='General description']"));
        flag = GenDescElem.isDisplayed();
        return flag;
    }

    public boolean requirementVisible() throws InterruptedException {
        boolean flag;
        WebElement GenDescElem = driver.findElement(By.xpath("//h2[normalize-space()='Requirements']"));
        flag = GenDescElem.isDisplayed();
        return flag;
    }

    public boolean responsibilitiesVisible() throws InterruptedException {
        boolean flag;
        WebElement GenDescElem = driver.findElement(By.xpath("//h2[normalize-space()='Responsibilities']"));
        flag = GenDescElem.isDisplayed();
        return flag;
    }


    public boolean whatWeOfferVisible() throws InterruptedException {
        boolean flag;
        WebElement GenDescElem = driver.findElement(By.xpath("//h2[normalize-space()='What we offer']"));
        flag = GenDescElem.isDisplayed();
        return flag;
    }

    public boolean verifyApplyButton() throws InterruptedException {
        boolean flag;
        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply']"));
        flag = applyButton.isDisplayed();
        return flag;
    }

    public void clickApplyButton()  {
        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply']"));
        elementClick(applyButton);
    }

    public void fillNameField(){
        WebElement name = driver.findElement(By.xpath("//input[@name='your-name']"));
        elementSendKeys(name,"Youmna");
    }

    public void fillEmailField(){
        WebElement email = driver.findElement(By.xpath("//input[@name='your-email']"));
        elementSendKeys(email,"email");
    }

    public void fillMobileField(){
        WebElement mobile = driver.findElement(By.xpath("//input[@name='mobile-number']"));
        elementSendKeys(mobile,"0125789977");
    }

    public void uploadCV(String path){

        WebElement uploadField = driver.findElement(By.xpath("//input[@id='uploadtextfield']"));
        elementSendKeys(uploadField,path);
    }

//    public void checkCaptcha(){
//
//            new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//            WebElement iFrame_checkbox = driver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark"));
//            elementHoverOver(iFrame_checkbox);
//            ClickByAction(iFrame_checkbox);
//            driver.switchTo().defaultContent();
//    }


    public void clickSend(){

        WebElement send = driver.findElement(By.xpath("//input[@value='Send']"));
        elementClick(send);
    }


    public void closeErrorButton(){

        WebElement errorClose = driver.findElement(By.xpath("//button[normalize-space()='Close']"));
        elementClick(errorClose);
    }

    public String emailIncorrectError(){

        WebElement error = driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap your-email']//span[@class='wpcf7-not-valid-tip']"));
        String message = error.getText();
        return message;
    }


}

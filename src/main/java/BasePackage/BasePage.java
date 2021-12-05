package BasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static BasePackage.BaseTest.driver;

public class BasePage {

    public static WebDriverWait wait;

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public static WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Some exception occured while creating webelement " + locator);
        }
        return element;
    }


    public static String getText(By locator) {
        wait = new WebDriverWait(driver,15);
        return getElement(locator).getText();
    }

    public static void elementClick(WebElement element) {
        element.click();
    }

    public static void elementClear(WebElement element) {
        element.clear();
    }

    public static void elementSendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void elementHoverOver(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void ClickByAction(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element);
        builder.perform();
    }

    public static String getPageCurrentURL() {
        String currentURL = null;
        try {
            currentURL = driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("some exception occurred while getting the current url " + currentURL);
        }
        return currentURL;
    }

    public static String handleNewTabAndGetURL(){
        String currentURL = null;
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        try {
            currentURL = driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("some exception occurred while getting the current url " + currentURL);
        }
        return currentURL;
    }

    public static void closeNewTab(){

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }



}

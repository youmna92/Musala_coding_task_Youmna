package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

import static BasePackage.BaseTest.driver;

public class joinUsPage extends BasePage {

    public void selectAnywhereLocationDrpDwn(){

        Select location = new Select(driver.findElement(By.id("get_location")));
        location.selectByValue("Anywhere");
    }

    public void selectSkopjeLocationDrpDwn(){

        Select location = new Select(driver.findElement(By.id("get_location")));
        location.selectByValue("Skopje");
    }

    public void selectSofiaLocationDrpDwn(){

        Select location = new Select(driver.findElement(By.id("get_location")));
        location.selectByValue("Sofia");
    }


    public void selectPositionByName(String posName){

        List<WebElement> allPositions = driver.findElements(By.xpath("//h2[@class='card-jobsHot__title']"));

        Iterator<WebElement> iter = allPositions.iterator();
        OUTER_LOOP:
        while(iter.hasNext()){
            WebElement position = iter.next();
            String positionName = position.getText();
            if(positionName.equals("Experienced Automation QA Engineer")){
                elementHoverOver(position);
                ClickByAction(position);
                break OUTER_LOOP;
            }
        }


    }

    public void printAllPositionNames (String location){

        System.out.println(location);
        List<WebElement> allPositions = driver.findElements(By.xpath("//h2[@class='card-jobsHot__title']"));
        Iterator<WebElement> iter = allPositions.iterator();
        while(iter.hasNext()){
            WebElement position = iter.next();
            String positionName = position.getText();
            System.out.println("Position: "+positionName);
            WebElement link = position.findElement(By.xpath("//h2[@class='card-jobsHot__title']/ancestor::a"));
            String linkText = link.getAttribute("href");
            System.out.println("More info: " + linkText);
        }
    }




}

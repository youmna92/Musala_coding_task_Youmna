package testClasses;

import BasePackage.BaseTest;
import Pages.careersPage;
import Pages.homePage;
import Pages.joinUsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase4 extends BaseTest {

    public static homePage homePageObject;
    public static careersPage careersPageObject;
    public static joinUsPage joinUsPageObject;

    @BeforeClass
    public void initialization(){
        homePageObject = new homePage();
        careersPageObject = new careersPage();
        joinUsPageObject = new joinUsPage();
    }

    @Test
    public void printAllPositionsTest(){

        homePageObject.clickCareersLink();
        careersPageObject.clickCheckOpenPositions();
        joinUsPageObject.selectSofiaLocationDrpDwn();
        joinUsPageObject.printAllPositionNames("Sofia");
        joinUsPageObject.selectSkopjeLocationDrpDwn();
        joinUsPageObject.printAllPositionNames("Skopje");

    }
}

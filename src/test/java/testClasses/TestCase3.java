package testClasses;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Pages.careersPage;
import Pages.homePage;
import Pages.jobPositionPage;
import Pages.joinUsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

    public static homePage homePageObject;
    public static careersPage careersPageObject;
    public static joinUsPage joinUsPageObject;
    public static jobPositionPage jobPositionPageObject;

    @BeforeClass
    public void initialization(){
        homePageObject = new homePage();
        careersPageObject = new careersPage();
        joinUsPageObject = new joinUsPage();
        jobPositionPageObject = new jobPositionPage();
    }

    @Test
    public void checkPositionsAnywhereTest() throws InterruptedException {

        homePageObject.clickCareersLink();
        careersPageObject.clickCheckOpenPositions();
        String currentURL = BasePage.getPageCurrentURL();
        Assert.assertEquals(currentURL,"https://www.musala.com/careers/join-us/");

        joinUsPageObject.selectAnywhereLocationDrpDwn();
        joinUsPageObject.selectPositionByName("Experienced Automation QA Engineer");

        Assert.assertTrue(jobPositionPageObject.generalDescriptionVisible());
        Assert.assertTrue(jobPositionPageObject.requirementVisible());
        Assert.assertTrue(jobPositionPageObject.responsibilitiesVisible());
        Assert.assertTrue(jobPositionPageObject.whatWeOfferVisible());

        Assert.assertTrue(jobPositionPageObject.verifyApplyButton());
        jobPositionPageObject.clickApplyButton();
        jobPositionPageObject.fillNameField();
        jobPositionPageObject.fillEmailField();
        jobPositionPageObject.fillMobileField();
        jobPositionPageObject.uploadCV("src/main/resources/Youmna_Elsayed.pdf");
        jobPositionPageObject.clickSend();
        jobPositionPageObject.closeErrorButton();
        String emailError = jobPositionPageObject.emailIncorrectError();
        Assert.assertEquals(emailError,"The e-mail address entered is invalid.");

    }
}

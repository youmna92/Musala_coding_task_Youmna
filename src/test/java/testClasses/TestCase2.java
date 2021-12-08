package testClasses;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Pages.companyPage;
import Pages.homePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    public static homePage homePageObject;
    public static companyPage companyPageObject;

    @BeforeClass
    public void initialization(){
        homePageObject = new homePage();
        companyPageObject = new companyPage();
    }

    @Test
    public void checkCompanyPage() throws InterruptedException {

        homePageObject.clickCompanyLink();
        String currentURL = BasePage.getPageCurrentURL();
        Assert.assertEquals(currentURL,"https://www.musala.com/company/");

        Assert.assertTrue(companyPageObject.leaderSectionVisible());

        companyPageObject.clickFacebookLink();
        String newTabURL = BasePage.handleNewTabAndGetURL();
        Assert.assertEquals(newTabURL,"https://www.facebook.com/MusalaSoft?fref=ts");
        boolean fbLogoVisible = companyPageObject.fbLogoVisible();
        Assert.assertTrue(fbLogoVisible);
        BasePage.closeNewTab();
    }
}

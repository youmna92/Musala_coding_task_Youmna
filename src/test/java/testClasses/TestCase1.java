package testClasses;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import Pages.homePage;
import com.codoid.products.exception.FilloException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest{

    public static homePage homePageObject;


    @BeforeClass
    public void initialization(){

        homePageObject = new homePage();
    }

    @Test
    public void fillContactUsForm() throws FilloException {


        for(int i=1;i<6;i++) {
            homePageObject.clickContactUs();
            String iteration = String.valueOf(i);
            System.out.println("iteration is: "+iteration);
            homePageObject.fillContactName(iteration);
            homePageObject.fillContactMobile(iteration);
            homePageObject.fillContactSubject(iteration);
            homePageObject.fillContactMessage(iteration);
            homePageObject.fillContactEmail(iteration);
            homePageObject.clickSubmit();
            String errorMessage = homePageObject.emailIncorrectError();
            Assert.assertEquals(errorMessage, "The e-mail address entered is invalid.");
            homePageObject.closeContactUs();
            BasePage.refreshPage();
        }

    }


}

package testhome;

import common.WebAPI;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import signUp.RegistrationPage;

public class HomePageTest extends WebAPI {
    HomePage homePage;
    RegistrationPage registrationPage;


    @BeforeMethod
    public void getInit() {
        homePage = PageFactory.initElements(driver,HomePage.class);
        registrationPage = PageFactory.initElements(driver,RegistrationPage.class);

    }


    @Test
    public void testSearchBoxCheck() {
        homePage.searchBoxCheck("Hand Sanitizer");
        homePage.validateSearchText("\"Hand Sanitizer\"");
    }

    @Test(enabled = true)
    public void testSearchBoxCheck1() {
        homePage.searchBoxCheck("Hand Sanitizer");
        homePage.validateSearchText("\"Hand Sanitizer1\"");
    }



}

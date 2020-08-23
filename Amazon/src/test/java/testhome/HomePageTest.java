package testhome;

import common.WebAPI;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends WebAPI {
    HomePage homePage;

    @BeforeMethod
    public void getInit() {
        homePage = PageFactory.initElements(driver,HomePage.class);
    }


    @Test
    public void testSearchBoxCheck() {
        homePage.searchBoxCheck("Hand Sanitizer");
        homePage.validateSearchText();
    }


}

package testhome;

import common.WebAPI;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;
import signUp.RegistrationPage;

public class HomePageTest extends WebAPI {
    HomePage homePage;
    RegistrationPage registrationPage;


    @BeforeMethod
    public void getInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

    }


    @Test
    public void testSearchBoxCheck() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        homePage.searchBoxCheck("Hand Sanitizer");
        homePage.validateSearchText("\"Hand Sanitizer\"");
    }

    @Test(enabled = true)
    public void testSearchBoxCheck1() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        homePage.searchBoxCheck("Hand Sanitizer");
        homePage.validateSearchText("\"Hand Sanitizer1\"");
    }

    @Test
    public void testSearchBoxCheckUsingGetItemValue() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        homePage.searchBoxCheckUsingGetItemValue();
        //homePage.validateSearchBoxCheckUsingGetItemValue();
    }

    @Test
    public void testSearchBoxCheckGetItemsListFromExcel() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        homePage.searchBoxCheckGetItemsListFromExcel();
    }

    @Test
    public void testSearchBoxCheckGetItemsListFromDB() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        homePage.searchBoxCheckGetItemsListFromDB();
    }


}

package home;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static home.HomePageWebElements.*;

public class HomePage extends WebAPI {
    String expectedResult;

    // Action Class: All the action methods and Validate methods

    // PageObject Design Pattern
    // Two way we can use @FindBY
    @FindBy(how = How.CSS, using = webElementSearchBox) public WebElement searchBox;

    @FindBy(how = How.CSS, using = webElementSearchButton) public WebElement searchButton;

    @FindBy(how = How.XPATH, using = webElementSearchText)
    public WebElement searchText;

//    @FindBy(css=webElementSearchBox)
//    private WebElement searchBox1;
//
//    public WebElement getSearchBox1() {
//        return searchBox1;
//    }
//
//    public void setSearchBox1(WebElement searchBox1) {
//        this.searchBox1 = searchBox1;
//    }


    // Action Method
    public void searchBoxCheck(String searchItem){
        searchBox.sendKeys(searchItem);
        searchButton.click();
    }

    // Validate Method
    public void validateSearchText(String expectedResult){
        String actualResult=searchText.getText();
       // String expectedResult="\"Hand Sanitizer\"";
        Assert.assertEquals(actualResult,expectedResult,"Search Item not match");
    }







}

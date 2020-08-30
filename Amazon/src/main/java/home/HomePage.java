package home;

import common.WebAPI;
import datadriven.DataSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import java.util.List;

import static home.HomePageWebElements.*;

public class HomePage extends WebAPI {
    String expectedResult;

    // Action Class: All the action methods and Validate methods

    // PageObject Design Pattern
    // Two way we can use @FindBY
    @FindBy(how = How.CSS, using = webElementSearchBox)
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = webElementSearchButton)
    public WebElement searchButton;

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
    public void searchBoxCheck(String searchItem) {
        searchBox.sendKeys(searchItem);
        searchButton.click();
    }

    // Validate Method
    public void validateSearchText(String expectedResult) {
        String actualResult = searchText.getText();
        // String expectedResult="\"Hand Sanitizer\"";
        Assert.assertEquals(actualResult, expectedResult, "Search Item not match");
    }

    public void login() {
        clickOnElement(webElementSearchBox);
        typeOnElement(webElementSearchBox, "I phone 11 pro max");

    }

    public void searchBoxCheckUsingGetItemValue() throws InterruptedException {
        List<String> itemList= DataSource.getItemValue();
        for (String st:itemList) {
            searchBox.sendKeys(st);
            searchBox.submit();
            String expectedResult="\""+st+"\"";
            System.out.println("Expected Result : "+expectedResult);
            String actualResult = searchText.getText();
            System.out.println("Actual Result : "+actualResult);
            Assert.assertEquals(actualResult, expectedResult, "Search Item not match");
            sleepFor(3);
            searchBox.clear();
        }
    }

    public void searchBoxCheckGetItemsListFromExcel() throws Exception {
        List<String> itemList= DataSource.getItemsListFromExcel();
        for (int i=1; i<itemList.size();i++){
            String item=itemList.get(i);
            searchBox.sendKeys(item);
            searchBox.submit();
            String expectedResult="\""+item+"\"";
            System.out.println("Expected Result : "+expectedResult);
            String actualResult = searchText.getText();
            System.out.println("Actual Result : "+actualResult);
            Assert.assertEquals(actualResult, expectedResult, "Search Item not match");
            sleepFor(3);
            searchBox.clear();
        }

    }
    public void searchBoxCheckGetItemsListFromDB() throws Exception {
        // Insert Data to a Database table
        DataSource.insertDataIntoDB();
        // Get Data From Database Table
        List<String> itemList= DataSource.getItemsListFromDB();
        for (int i=1; i<itemList.size();i++){
            String item=itemList.get(i);
            searchBox.sendKeys(item);
            searchBox.submit();
            String expectedResult="\""+item+"\"";
            System.out.println("Expected Result : "+expectedResult);
            String actualResult = searchText.getText();
            System.out.println("Actual Result : "+actualResult);
            Assert.assertEquals(actualResult, expectedResult, "Search Item not match");
            sleepFor(3);
            searchBox.clear();
        }

    }



}

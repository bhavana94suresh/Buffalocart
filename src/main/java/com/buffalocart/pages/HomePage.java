package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestHelperUtility {
    WebDriver driver;

    /**page Constructor**/
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /** page element **/

    private final String _userName = "//a[@class='dropdown-toggle']";
    @FindBy(xpath = _userName) private WebElement userName;

    private final String _homePageTitle = "//span[@class='logo-lg']";
    @FindBy(xpath = _homePageTitle) private WebElement homePageTitle;

    private final String _endTour="//button[@class='btn btn-default btn-sm' ]";
    @FindBy(xpath = _endTour) private WebElement endTour;

    private final String _dateDisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']/strong";
    @FindBy(xpath = _dateDisplayed) private WebElement dateDisplayed;




    /** user action method **/

    public String getUserAccountName(){
        String uname = page.getElementText(userName);
        return uname;
    }
    public String getHomePageTitle(){
        return  page.getPageTitleValue(driver);
    }
    public String getDateDisplayedOnHomePage(){
        return page.getElementText(dateDisplayed);
    }
    public String getSystemDate(){
        return date.getDateOfSystem();
    }

    public void clickOnEndTour(){
        page.clickOnElement(endTour);
    }



}

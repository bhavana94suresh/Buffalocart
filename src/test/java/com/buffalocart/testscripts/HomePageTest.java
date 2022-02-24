package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListeners;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    HomePage home;
    LoginPage login;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();

    @Test(priority = 1,description = "TC_006_Verify home page tilte")
    public void verify_Home_Page_Title(){
        login=new LoginPage(driver);
        List<List<String>> data=excel.excelDataReader("homePage");

        home=login.clickOnLoginButton();
        String actualHomePageTitle=home.getHomePageTitle();
        extentTest.get().log(Status.PASS, "Home page title recieved");
        String expectedHomePageTitle=data.get(1).get(2);
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle,"ERROR ::Invalid Title");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }




    @Test(priority = 2,description = "TC_007_Verify date displayed in home page")
    public void verify_date_displayed_in_home_page(){
        login=new LoginPage(driver);
        List<List<String>> data=excel.excelDataReader("homePage");
        String uname=data.get(1).get(0);
        login.enterUserName(uname);
        String pswd=data.get(1).get(1);
        login.enterPassword(pswd);
        home=login.clickOnLoginButton();
        home.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button");
        String actualDate=home.getDateDisplayedOnHomePage();
        extentTest.get().log(Status.PASS, "Home page actual date recieved");
        String expectedDate= home.getSystemDate();
        extentTest.get().log(Status.PASS, " system date  recieved");
        Assert.assertEquals(actualDate,expectedDate,"ERROR ::Not current Date");
        extentTest.get().log(Status.PASS, "system date is matched with actual home page date");
    }

}

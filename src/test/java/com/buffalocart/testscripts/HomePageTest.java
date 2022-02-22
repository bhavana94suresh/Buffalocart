package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListeners;
import com.buffalocart.pages.HomePage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    HomePage home;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();;

    @Test(priority = 1,description = "TC_001_Verification of home page title")

    public void verify_login_page_title(){
        extentTest.get().assignCategory("Smoke");
        home=new HomePage(driver);
        List<String> data=excel.readDataFromExcel("loginPage");
        String expectedHomePageTitle=data.get(1);
       // String actualHomePageTitle=home.getHomePageTitle();
      //  extentTest.get().log(Status.PASS, "Login page title recieved");
       // Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle,"ERROR::invalid HomePage Title");
       // extentTest.get().log(Status.PASS, "Expected title is mached with actual home page title");


    }
}

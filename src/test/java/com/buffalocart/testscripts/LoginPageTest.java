package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListeners;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest extends Base {
HomePage home;
LoginPage login;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();
    @Test(priority = 1,description = "TC_001_Verification of user login page title")

    public void verify_login_page_title(){
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<List<String>> data=excel.excelDataReader("LoginPage");
        String expectedTitle= data.get(1).get(0);
        String actualTitle= login.getLoginPagetitle();
        extentTest.get().log(Status.PASS, "Login page title recieved");
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR ::Invalid Title");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }

    @Test(priority =2,description = "TC_001_Verification of user login with valid credentials")

public void Verify_user_login_with_valid_user_credentials (){
    login=new LoginPage(driver);
    List<List<String>> data = excel.excelDataReader("loginPage");
    String uname = data.get(1).get(0);
    login.enterUserName(uname);
    extentTest.get().log(Status.PASS, "User name enetred successfully");
    String pwrd = data.get(1).get(1);
    login.enterPassword(pwrd);
    extentTest.get().log(Status.PASS, "Password enetred successfully");
    home=login.clickOnLoginButton();
    extentTest.get().log(Status.PASS, "clicked on login button successfully");
}
}

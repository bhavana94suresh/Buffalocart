package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListeners;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest extends Base {
    HomePage home;
    LoginPage login;
    ResetPage reset;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();


    @Test(priority = 1, description = "TC_001_Verification of user login page title")
    public void verify_login_page_title() {
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("loginPage");
        String expectedTitle = data.get(0).get(0);
        String actualTitle = login.getLoginPagetitle();
        extentTest.get().log(Status.PASS, "Login page title recieved");
        Assert.assertEquals(actualTitle, expectedTitle, "ERROR ::Invalid Title");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }

    @Test(priority = 2, description = "TC_001_Verification of user login with valid credentials")

    public void Verify_user_login_with_valid_user_credentials() {
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("loginPage");
        String uname = data.get(2).get(0);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        String pwrd = data.get(2).get(1);
        login.enterPassword(pwrd);
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
    }

    @Test(priority = 3, description = "TC_003_Verify the error message displayed for user login with invalid credentials")
    public void verify_User_Login_With_InvalidUser_Credentials() {
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("loginPage");
        String uname = data.get(2).get(0);
        login.enterUserName(uname);
        String psd = data.get(2).get(1);
        login.enterPassword(psd);
        home = login.clickOnLoginButton();
        String actualErrorMessage = login.getErrorMessage();
        String expectedUserAccountName = data.get(3).get(0);
        Assert.assertEquals(actualErrorMessage, expectedUserAccountName, "ERROR ::Invalid user");
        extentTest.get().log(Status.PASS, "invalid User name entered successfully");
        extentTest.get().log(Status.PASS, "invalid Password entered successfully");
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        extentTest.get().log(Status.PASS, "Expected error message matched with actual error message ");
    }

    @Test(priority = 4, description = "TC_004_Verify whetehr the user is able to click on 'Remember me' checkbox")
    public void verify_Whether_User_Able_To_Click_On_RemememberMe_CheckBox() {
        login = new LoginPage(driver);
        login.clickOnRememberMeCheckBox();
        extentTest.get().log(Status.PASS, "clicked on CheckBox successfully");
        login.rememberMeCheckBoxIsSelected();
        extentTest.get().log(Status.PASS, "CheckBox  selected successfully");
        Assert.assertTrue(login.rememberMeCheckBoxIsSelected());
        extentTest.get().log(Status.PASS, "Assertion True for checkbox selected ");
    }

    @Test(priority = 5, description = "TC_005_Verify error meesage displyed on  Reset Password page with invalid email id ")
    public void verify_error_msg_displayed_on_Reset_password_with_invalid_email_Id() {
        login = new LoginPage(driver);
        reset = login.clickOnForgotPassword();
        extentTest.get().log(Status.PASS, "clicked on forgot password");
        List<List<String>> data = excel.excelDataReader("resetPage");
        String email = data.get(1).get(0);
        reset.enterEmail(email);
        extentTest.get().log(Status.PASS, " entered email id");
        reset.clickOnSendPasswordLink();
        extentTest.get().log(Status.PASS, " clicked on send password link");
        String excpectedErrorMsg = data.get(1).get(1);
        System.out.println(excpectedErrorMsg);
        String actualErrorMsg = reset.getErrorMessage();
        Assert.assertEquals(actualErrorMsg, excpectedErrorMsg, "invalid error message");
        extentTest.get().log(Status.PASS, "Expected error message matches actual message");

    }
}



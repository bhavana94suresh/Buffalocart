package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListeners;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignOut;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.annotations.Test;

import java.util.List;

public class SignOutTest extends Base {
        HomePage home;
        LoginPage login;
        ExcelUtility excel = new ExcelUtility();
        SignOut signOut;
        ThreadLocal<ExtentTest> extentTest = TestListeners.getTestInstance();


    @Test(priority = 1,description ="TC_008_Verify whether user is navigating to login page by clicking on Sign out button")
    public void  verify_Whether_User_Is_Navigating_To_Login_Page_By_Clicking_On_Sign_Out_Button(){
        extentTest.get().assignCategory("Smoke");
        login=new LoginPage(driver);
        signOut=new SignOut(driver);
        List<List<String>> data=excel.excelDataReader("homePage");
        String uname=data.get(1).get(0);
        login.enterUserName(uname);
        String pswd=data.get(1).get(1);
        login.enterPassword(pswd);
        home=login.clickOnLoginButton();
        home.clickOnEndTour();
        extentTest.get().log(Status.PASS, "clicked on end tour button");
        signOut.clickOnUserOnHomePage();
        extentTest.get().log(Status.PASS, "clicked on end user button");
        String text=data.get(1).get(3);
        login=signOut.selectFromDropDownForSignOut(text);
        extentTest.get().log(Status.PASS, "clicked on sign out and navigated to sign out page");

    }
}

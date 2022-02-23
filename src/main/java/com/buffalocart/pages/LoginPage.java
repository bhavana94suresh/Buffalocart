package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
     public  WebDriver driver;

    /**page Constructor**/
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*** page elements **/

    private final String _pageTitle="//h1[@class='text-center page-header']";
    @FindBy(xpath =_pageTitle ) private WebElement pageTitle;

    private final String _userName = "username";
    @FindBy(id = _userName) private WebElement username;

    private final String _password = "password";
    @FindBy(id = _password) private WebElement password;

    private final String _rememberCheckbox = "//input[@name='remember']";
    @FindBy(xpath = _rememberCheckbox) private WebElement rememberCheckbox;

    private final String _login = "//button[@type='submit']";
    @FindBy(xpath = _login) private WebElement login;

    private final String _errorMessage="//span[@class='help-block']";
    @FindBy(xpath =_errorMessage) private WebElement errorMessage;

    private final String _forgotPassword="//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotPassword) private WebElement forgotPassword;


    /**user action methods**/

    public String getLoginPagetitle(){
         return page.getPageTitleValue(driver);  }

    public void enterUserName(String uname){
        page.enterText(username,uname);
    }

    public void enterPassword(String pwrd){
        page.enterText(password,pwrd);
    }

        public HomePage clickOnLoginButton(){
        page.clickOnElement(login);
        return new HomePage(driver);
    }

    public void clickOnRememberMeCheckBox(){
        page.clickOnElement(rememberCheckbox);
    }
    public boolean rememberMeCheckBoxIsSelected(){
        return page.isSelected(rememberCheckbox);
    }
    public String getErrorMessage(){
        return   page.getElementText(errorMessage);
    }
    public ResetPage clickOnForgotPassword(){
        page.clickOnElement(forgotPassword);
        return new ResetPage(driver);
    }

}

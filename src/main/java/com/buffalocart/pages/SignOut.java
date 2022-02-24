package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignOut extends TestHelperUtility {
    WebDriver driver;

    /**page Constructor**/
    public SignOut(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /** page element **/

    private final String _userNameOnHomePage="//li[@class='dropdown user user-menu']";
    @FindBy(xpath = _userNameOnHomePage) private WebElement userNameOnHomePage;

    private final String _signOutOptions="//div[@class='pull-left' or @class='pull-right']";
    @FindBy(xpath = _signOutOptions) private List<WebElement> signOutOptions;


    /** user action method**/
    public void clickOnUserOnHomePage(){
        page.clickOnElement(userNameOnHomePage);
    }

    public LoginPage selectFromDropDownForSignOut(String text) {
        for (int i = 0; i < signOutOptions.size(); i++) {
            String value = signOutOptions.get(i).getText();
            if (value.equals(text)) {
                page.clickOnElement(signOutOptions.get(i));
                break;
            }
        }
        return new LoginPage(driver);
    }
}

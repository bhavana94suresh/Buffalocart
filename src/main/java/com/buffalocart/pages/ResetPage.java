package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends TestHelperUtility {
    public WebDriver driver;

    /**page Constructor**/
    public ResetPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*** page elements **/

    private final String _errorMsg="//span[@class='help-block']/strong";
    @FindBy(xpath = _errorMsg) private WebElement errorMsg;

    private final String _email="email";
    @FindBy(id = _email) private WebElement email;

    private final String _sendPasswordLink="//button[@type='submit']";
    @FindBy(xpath = _sendPasswordLink) private WebElement sendPasswordLink;


    /** user action method **/
    public String getErrorMessage(){
       return page.getElementText(errorMsg);
    }

    public void enterEmail(String emaillink){
        page.enterText(email,emaillink);
    }

    public void clickOnSendPasswordLink(){
        page.clickOnElement(sendPasswordLink);
    }

}

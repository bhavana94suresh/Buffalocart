package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
    public WebDriver driver;

    /**page Constructor**/
    public ResetPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*** page elements **/
}

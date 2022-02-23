package com.buffalocart.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.Set;

public class PageUtility {

        public void clickOnElement(WebElement element) {
        element.click();
    }

        public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

        public String getElementText(WebElement element) {
        return element.getText();
    }

        public String getPageTitleValue(WebDriver driver){
        return driver.getTitle();
    }

        public String getValueOfAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

        public String getTagNameOfElement(WebElement element) {
        return element.getTagName();
    }

        public Dimension getElementSize(WebElement element) {
        return element.getSize();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

        public void selectDropDownByText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

        public void selectDropDownByIndex(WebElement element, int value) {
        Select select = new Select(element);
        select.selectByIndex(value);
    }

        public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

        public void selectDropDownByIsMultiple(WebElement element) {
        Select select = new Select(element);
        select.isMultiple();
    }

        public void DropDownByDeselectAll(WebElement element) {
        Select select = new Select(element);
        select.deselectAll();
    }

        public void deselectDropDownByByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }

        public void deselectDropDownByIndex(WebElement element, int value) {
        Select select = new Select(element);
        select.deselectByIndex(value);
    }

        public void deselectDropDownByText(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByVisibleText(value);
    }

        public void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

        public String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

        public void alertDismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

        public void alertPrompt(WebDriver driver, String value) {

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

        public void doubleClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
    }

        public void dragAndDropAnElement(WebDriver driver, WebElement source, WebElement target) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
    }

        public void dragAndDropByToaPosition(WebElement source, WebDriver driver, int x, int y) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(source, x, y);

    }

        public void clickAndHoldElement(WebDriver driver, WebElement drag, WebElement drop) {
        Actions action = new Actions(driver);
        action.clickAndHold(drag).moveToElement(drop).build().perform();
    }


        public void moveToAnElement(WebDriver driver, WebElement drag, WebElement drop) {
        Actions action = new Actions(driver);
        action.moveToElement(drop).build().perform();
    }

        public void rightClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element);
    }

        public void navigateToForward(WebDriver driver) {
        driver.navigate().forward();
    }

        public void navigateToBackward(WebDriver driver) {
        driver.navigate().back();
    }

        public void navigateToRefreshButton(WebDriver driver) {
        driver.navigate().refresh();
    }

        public void navigateToApplication(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

        public void switchToframeByIndex(WebDriver driver, int i) {
        Frame frame = new Frame();
        driver.switchTo().frame(i);
    }

        public void switchToframeByNameOrId(WebDriver driver, String value) {
        Frame frame = new Frame();
        driver.switchTo().frame(value);
    }

        public void switchToframeByWebElement(WebDriver driver, WebElement element) {
        Frame frame = new Frame();
        driver.switchTo().frame(element);
    }

        public String getwindowHandleId(WebDriver driver) {
        return driver.getWindowHandle();

    }

        public Set<String> getwindowHandlesId(WebDriver driver) {
        return driver.getWindowHandles();
    }

        public void javaScriptScroll(WebDriver driver,int x,long y) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(x,y)");
    }

        public void javaScriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }
        public void javaScriptGetAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('" + message + "')");
    }

        public void javaScriptSendKeys(WebDriver driver,String id,String values) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById('id').value='values'");
    }

}

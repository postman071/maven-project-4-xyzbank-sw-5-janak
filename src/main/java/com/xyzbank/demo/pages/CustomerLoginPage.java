package com.xyzbank.demo.pages;

import com.xyzbank.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    By logoutButton = By.xpath("//button[contains(text(),'Logout')]");
    By verifyLogoutTab = By.xpath("//button[@class='btn logout']");
    By verifyNameText = By.xpath("//span[contains(text(),'Ron Weasly')]");


    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement yourName;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logout;

    By logoutTab = By.xpath("//button[text()='Logout']");

    @CacheLookup
    @FindBy(xpath = "//label[text()='Your Name :']")
    WebElement yourNameText;

    public void selectYourName(String text)
    {
        Reporter.log("Select Name"+yourName.toString());
        selectByVisibleTextFromDropDown((By) yourName,text);
        clickOnElement(loginButton);

    }

    //Click on login button
    public void clickOnLoginTab()
    {
        Reporter.log("Click on Login Button"+loginButton.toString());
        WebElement element;
        clickOnElement(loginButton);
    }
    //Click on logout button
    public void clickOnLogoutTab()
    {
        Reporter.log("Click on Logout Button"+logoutButton.toString());
        WebElement element;
        clickOnElement(logoutButton);
    }
    //Verify logout text
    public String verifyLogoutText()
    {
        Reporter.log("To verify Logout Text"+verifyLogoutTab.toString());
        WebElement element;
        return getTextFromElement(verifyLogoutTab);
    }
    //Verify your Name Text
    public String verifyYourNameText()
    {
        Reporter.log("To Verify Name Text"+verifyNameText.toString());
        WebElement element;
        return getTextFromElement(verifyNameText);
    }
}
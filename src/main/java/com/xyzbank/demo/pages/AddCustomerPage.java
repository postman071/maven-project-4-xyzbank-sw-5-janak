package com.xyzbank.demo.pages;

import com.xyzbank.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility
{

    By addCustomerTab = By.xpath("//button[contains(text(),'Add Customer')]");
    By firstName = By.xpath("//input[@placeholder='First Name']");
    By lastName = By.xpath("//input[@placeholder='Last Name']");
    By postCode = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.xpath("//button[@class='btn btn-default']");

    @CacheLookup
    @FindBy(xpath = "//div[1]/input[1]")
    WebElement firstname;
    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastname;
    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Home']")
    WebElement homeButton;
    //Click on add customer tab
    public void clickOnAddCustomerTab()
    {
        Reporter.log("Click on Customer tab"+addCustomerTab.toString());
        WebElement element;
        clickOnElement(addCustomerTab);
    }
    //Enter all fields
    public void enterAddCusterFields()
    {
        Reporter.log("Add First Name"+firstName.toString());
        sendTextToElement(firstName,"Ron");
        Reporter.log("Add Last Name"+lastName.toString());
        sendTextToElement(lastName,"Weasly");
        Reporter.log("Add postCode "+postCode.toString());
        sendTextToElement(postCode,"cr0 6dh");
    }
    //Click on add customer button
    public void clickOnAddCustomerButton()
    {
        Reporter.log("Click on add to Customer "+addCustomerButton.toString());
        clickOnElement(addCustomerButton);
    }
    public String getTheTextFromAlert()
    {
        Reporter.log("Get the text from alert");
        String text = driver.switchTo().alert().getText();
        return text;
    }
    public void clickOk()
    {
        Reporter.log("Click on ok button in alert");
        acceptAlert();
    }
    public void clickOnHomeButton()
    {
        Reporter.log("Click on home button" + homeButton.toString());
        clickOnElement(homeButton);
    }
}


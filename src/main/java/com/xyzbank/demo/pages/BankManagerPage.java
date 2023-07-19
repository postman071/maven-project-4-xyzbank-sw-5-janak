package com.xyzbank.demo.pages;

import com.xyzbank.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerPage extends Utility
{
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    public void clickOnAddCustomerTab() {
        Reporter.log("CLick on add customer tab" + addCustomer.toString());
        clickOnElement(addCustomer);
    }

    public void clickOnOpenAccountTab() {
        Reporter.log("Click on open account tab" + openAccount.toString());
        clickOnElement(openAccount);
    }
}

package com.xyzbank.demo.testsuite;

import com.xyzbank.demo.basetest.BaseTest;
import com.xyzbank.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest
{
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerPage bankManagerPage;
    CustomerLoginPage customerLoginPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerPage = new BankManagerPage();
        customerLoginPage = new CustomerLoginPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginLink();
        bankManagerPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName("Ron");
        addCustomerPage.enterLastName("Weasly");
        addCustomerPage.enterPostCode("cr0 6dh");
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertTrue(addCustomerPage.getTheTextFromAlert().contains("Customer added successfully"), "Customer added successfully is not displayed in popup");
        addCustomerPage.clickOk();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {

        bankManagerShouldAddCustomerSuccessfully();
        bankManagerPage.clickOnOpenAccountTab();
        // openAccountPage.searchCustomerName("Ron Weasly");
        // openAccountPage.selectCurrencyFromDropDown("Pound");
        // openAccountPage.clickOnProcessButton();
        Assert.assertTrue(openAccountPage.getTheTextFromAlert().contains("Account created successfully"));
        openAccountPage.clickOk();
    }

    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() {
        bankManagerShouldAddCustomerSuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Ron Weasly");
        customerLoginPage.clickOnLoginTab();
        customerLoginPage.clickOnLogoutTab();
        customerLoginPage.clickOnLogoutTab();
        Assert.assertEquals(customerLoginPage.verifyYourNameText(), "Your Name :");
    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Ron Weasly");
        customerLoginPage.clickOnLoginTab();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount();
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.getDepositSuccessfulMessage(), "Deposit Successful");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully()
    {
        customerShouldDepositMoneySuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Ron Weasly");
        customerLoginPage.clickOnLoginTab();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount();
        accountPage.clickOnWithdrawlButton();

    }
}

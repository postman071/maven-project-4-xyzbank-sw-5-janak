package com.xyzbank.demo.pages;

import com.xyzbank.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility
{
    By openAccountTab = By.xpath("//button[normalize-space()='Open Account']");
    By selectName = By.xpath("//select[@id='userSelect']");
    By selectCurrency = By.xpath("//select[@id='currency']");
    By processButton = By.xpath("//button[contains(text(),'Process')]");


    @CacheLookup
    @FindBy(xpath = "//div[1]/input[1]")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Home']")
    WebElement homeButton;


    public void enterFirstName(String name)
    {
        Reporter.log("Enter first name " + firstName.toString());
        sendTextToElement(firstName, name);
    }
    public void enterLastName(String surname)
    {
        Reporter.log("Enter last name" + lastName.toString());
        sendTextToElement(lastName, surname);
    }
    public void enterPostCode(String pCode)
    {
        Reporter.log("Enter postcode" + postcode.toString());
        sendTextToElement(postcode, pCode);
    }
    public void clickOnAddToCustomerButton()
    {
        Reporter.log("Click on add to customer button" + addCustomer.toString());
        clickOnElement(addCustomer);
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

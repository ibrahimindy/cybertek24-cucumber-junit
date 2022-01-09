package com.cydeo.pages.EtsyPages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PercentCalculatorPage {

    public PercentCalculatorPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//form[@id='f1']//input[@size='3']")
    public WebElement percent;

    @FindBy (xpath = "//form[@id='f1']//input[@size='7']")
    public WebElement input;

    @FindBy (xpath = "//form[@id='f1']//input[@value='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//form[@id='f1']//input[@readonly='readonly']")
    public WebElement result;
}

package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudTablesPage {

    public CloudTablesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='dt-button buttons-create']")
    public WebElement newButton;

    @FindBy (id = "DTE_Field_first_name")
    public WebElement firstNameField;

    @FindBy (id = "DTE_Field_last_name")
    public WebElement lastNameField;

    @FindBy (id = "DTE_Field_position")
    public WebElement positionField;

    @FindBy (id = "DTE_Field_salary")
    public WebElement salaryField;

    @FindBy (className = "DTE_Form_Buttons")
    public WebElement createButton;

}

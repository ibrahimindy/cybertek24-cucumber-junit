package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "sciOutPut")
    public WebElement resultElem;

    /**
     * clickOn("5"); it should click 5 on calc
     * clickOn("7"); it should click 7 on calc
     * clickOn("+"); it should click + on calc
     * //span[.='text of btn']
     */
    public void clickOn(String buttonText) {
        WebElement elem = Driver.getDriver().findElement(By.xpath("//span[.='" + buttonText + "']"));
        elem.click();
    }
}

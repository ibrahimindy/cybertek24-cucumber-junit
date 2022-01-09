package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPages.PercentCalculatorPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class PercentageCalculatorStepDefs {

    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("percentage.url"));


    }
    @Then("User should see following calculations:")
    public void user_should_see_following_calculations(Map<Integer,Integer> valuesMap) {
        System.out.println("valuesMap = "+valuesMap);

        PercentCalculatorPage calculatorPage=new PercentCalculatorPage();
        calculatorPage.percent.sendKeys("5");


        for(Integer inputKey : valuesMap.keySet()){

            calculatorPage.input.clear();
            calculatorPage.input.sendKeys(""+inputKey+ Keys.ENTER);
            BrowserUtils.sleep(1);

            System.out.println("INPUT VALUE = "+inputKey);
            System.out.println("EXPECTED 5% VALUE= "+valuesMap.get(inputKey));
            System.out.println("ACTUAL 5% VALUE = "+ calculatorPage.result.getAttribute("value"));
            System.out.println("===========================");
            Assert.assertEquals(valuesMap.get(inputKey),Integer.valueOf(calculatorPage.result.getAttribute("value")));
        }

    }

}

package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }
    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        System.out.println("USER ENTER JAVA AND 22102....");
        WebElement keyword=Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipCode=Driver.getDriver().findElement(By.id("google-location-search"));
        keyword.sendKeys("java");
        zipCode.sendKeys("46037"+ Keys.ENTER);
    }
    @Then("User should see search results")
    public void user_should_see_search_results() {
     WebElement jobCount=Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("Job count = "+jobCount.getText());
        BrowserUtils.sleep(2);
    }
}

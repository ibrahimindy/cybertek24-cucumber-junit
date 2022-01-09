package com.cydeo.step_definitions;

import com.cydeo.pages.CloudTablesPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CloudTablesStepDefs {
    CloudTablesPage cloudTablesPage=new CloudTablesPage();
    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Editor | Editing for DataTables");

    }
    @When("User clicks on New button")
    public void user_clicks_on_new_button() {
      cloudTablesPage.newButton.click();
    }
    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String string) {

    cloudTablesPage.firstNameField.sendKeys(string);

    }
    @When("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String string) {
    cloudTablesPage.lastNameField.sendKeys(string);

    }
    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String string) {
     cloudTablesPage.positionField.sendKeys(string);

    }
    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String string) {

     cloudTablesPage.salaryField.sendKeys(string);

    }
    @When("User clicks on create button")
    public void user_clicks_on_create_button() {

     cloudTablesPage.createButton.click();



    }

}

package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }

    @When("User searches for apple")
    public void user_searches_for_apple() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "apple";

        assertTrue(actualTitle.contains(expectedInTitle));
    }

    @Then("User should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> items) {
        System.out.println("items = " + items);
        GoogleSearchPage searchPage = new GoogleSearchPage();

        for (String eachItem : items) {
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(eachItem + Keys.ENTER);
        }
    }
    @When("User searches for {string} capital")
    public void userSearchesForCapital(String countryName) {
        System.out.println("Searching for capital city of " + countryName);
        googleSearchPage.searchBar.sendKeys("What is the capital city of " + countryName + Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalCity) {
        System.out.println("Expected Capital City name: " + capitalCity);
        Assert.assertEquals(capitalCity,googleSearchPage.searchResultCityName.getText());
    }
}

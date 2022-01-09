package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPages.EtsyAllCategoriesPage;
import com.cydeo.pages.EtsyPages.EtsyHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsySearchStepsDefs {

    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
    }
    @Then("Page title should be as expected")
    public void page_title_should_be_as_expected() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"));
    }
    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        EtsyHomePage etsyHomePage=new EtsyHomePage();
        etsyHomePage.searchFor("wooden spoon");
    }
    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(Driver.getDriver().getTitle().startsWith("Wooden spoon"));
    }

    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage etsyHomePage=new EtsyHomePage();
        etsyHomePage.searchFor("");
        
    }

    @Then("All categories should be displayed")
    public void allCategoriesShouldBeDisplayed() {


        Assert.assertEquals("All categories | Etsy", Driver.getDriver().getTitle());

        EtsyAllCategoriesPage allCategoriesPage = new EtsyAllCategoriesPage();
        Assert.assertTrue(allCategoriesPage.allCategoriesHeader.isDisplayed());


    }
}

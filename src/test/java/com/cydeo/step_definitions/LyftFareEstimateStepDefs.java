package com.cydeo.step_definitions;

import com.cydeo.pages.LyftFareEstimatePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LyftFareEstimateStepDefs {

    LyftFareEstimatePage fareEstimatePage = new LyftFareEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Lyft fare estimate page is not displayed", expectedTitle, actualTitle);
    }
    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickUpLocation) {

        //need to add a page object class for the Lyft estimate page
        LyftFareEstimatePage fareEstimatePage = new LyftFareEstimatePage();

        //fareEstimatePage.pickUp.sendKeys(pickUpLocation);

        fareEstimatePage.enterPickUpLocation(pickUpLocation);

    }
    @When("User enters {string} to drop-off address")
    public void user_enters_to_drop_off_address(String dropOffLocation) {
        fareEstimatePage.dropOff.sendKeys(dropOffLocation);
    }
    @When("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {
        //Actions actions = new Actions(Driver.getDriver());
        //fareEstimatePage.getEstimateBtn.click();
        //actions.moveToElement(fareEstimatePage.getEstimateBtn).doubleClick().build().perform();
        fareEstimatePage.getEstimateBtn.click();
        BrowserUtils.sleep(1);
        fareEstimatePage.getEstimateBtn.click();

    }
    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        assertTrue(fareEstimatePage.rideTypesHeader.isDisplayed());
        System.out.println("Lyft Estimated price and time = " + fareEstimatePage.liftPrice.getText());
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
     assertTrue("Error message is not displayed",fareEstimatePage.errorMsg.isDisplayed());
    }

}

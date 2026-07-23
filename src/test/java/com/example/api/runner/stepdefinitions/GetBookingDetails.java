package com.example.api.runner.stepdefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import services.BookingServices;

public class GetBookingDetails extends BaseTest {

    private Response response;

    @When("User retrieves the booking details")
    public void userRetrievesTheBookingDetails() {

        System.out.println("Booking ID : " + CreateBooking.bookingId);

        response = BookingServices.getBooking(CreateBooking.bookingId);
    }

    @Then("User should receive the booking details successfully")
    public void userShouldReceiveTheBookingDetailsSuccessfully() {

        System.out.println("========= GET Response =========");
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(response.jsonPath().getString("firstname"));

        Assert.assertNotNull(response.jsonPath().getString("lastname"));

        Assert.assertNotNull(response.jsonPath().getInt("totalprice"));
    }
}
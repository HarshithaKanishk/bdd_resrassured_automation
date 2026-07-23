package com.example.api.runner.stepdefinitions;


import org.testng.Assert;

import base.BaseTest;
import config.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Booking;
import services.BookingServices;
import utility.JsonUtil;
import utility.GenerateToken;

public class UpdateBooking extends BaseTest {
    

    private Booking booking;
    private Response response;

    public static int bookingId;

    @Given("User has booking details for update")
public void userHasBookingDetailsForUpdate() {

    System.out.println("******** UPDATE GIVEN EXECUTED ********");

    booking = JsonUtil.readJsonFile(
            Constants.UPDATE_JSON_PATH,
            Booking.class);

    System.out.println("Booking = " + booking);
}

    @When("User update a booking")
    public void userUpdatesABooking() {

        String token=GenerateToken.generateToken();

        System.out.println("Generated Token : " + token);
    System.out.println("Booking ID : " + CreateBooking.bookingId);
    System.out.println("Booking Object : " + booking);

        response = BookingServices.updateBooking(CreateBooking.bookingId, token, booking);

      

        // bookingId = response.jsonPath().getInt("bookingid");

        // System.out.println("Updated Booking ID : " + bookingId);
    }

    @Then("Booking should be updated successfully")
    public void bookingShouldBeUpdatedSuccessfully() {

        response.then().statusCode(200);

        response.prettyPrint();

        //Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");

        String firstName = response.jsonPath().getString("firstname");
        String lastName = response.jsonPath().getString("lastname");
        int totalPrice = response.jsonPath().getInt("totalprice");

        Assert.assertEquals(firstName, booking.getFirstname());
        Assert.assertEquals(lastName, booking.getLastname());
        Assert.assertEquals(totalPrice, booking.getTotalprice());

        System.out.println("Booking updated successfully.");
    }
}

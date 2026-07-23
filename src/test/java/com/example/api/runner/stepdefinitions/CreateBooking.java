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

public class CreateBooking extends BaseTest {

    private Booking booking;
    private Response response;

    public static int bookingId;

    @Given("User has booking details")
    public void userHasBookingDetails() {

        booking = JsonUtil.readJsonFile(
                Constants.CREATE_BOOKING_JSON_PATH,
                Booking.class);

        Assert.assertNotNull(booking, "Booking data should not be null");
    }

    @When("User creates a booking")
    public void userCreatesABooking() {

        response = BookingServices.createBooking(booking);

        bookingId = response.jsonPath().getInt("bookingid");

        System.out.println("Created Booking ID : " + bookingId);
    }

    @Then("Booking should be created successfully")
    public void bookingShouldBeCreatedSuccessfully() {

        response.then().statusCode(200);

        response.prettyPrint();

        Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");

        String firstName = response.jsonPath().getString("booking.firstname");
        String lastName = response.jsonPath().getString("booking.lastname");
        int totalPrice = response.jsonPath().getInt("booking.totalprice");

        Assert.assertEquals(firstName, booking.getFirstname());
        Assert.assertEquals(lastName, booking.getLastname());
        Assert.assertEquals(totalPrice, booking.getTotalprice());

        System.out.println("Booking created successfully.");
    }
}
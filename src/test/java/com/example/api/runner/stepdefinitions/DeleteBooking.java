package com.example.api.runner.stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import services.BookingServices;

import utility.GenerateToken;

public class DeleteBooking extends BaseTest {

   // private Booking booking;
    private Response response;

    public static int bookingId;

    @Given("User has booking details for delete")
    public void userHasBookingDetailsForDelete() {

         String token = GenerateToken.generateToken();

        System.out.println("Generated Token : " + token);

        response = BookingServices.deleteBooking(
                CreateBooking.bookingId,
                token);
    }

    // @When("User update a booking")
    // public void userUpdatesABooking() {

    //     String token=GenerateToken.generateToken();

    //     System.out.println("Generated Token : " + token);

    //     response = BookingServices.updateBooking(CreateBooking.bookingId, token, booking);

    //     bookingId = response.jsonPath().getInt("bookingid");

    //     System.out.println("Updated Booking ID : " + bookingId);
    // }

    @Then("Booking should be deleted successfully")
    public void bookingShouldBeDeletedSuccessfully() {

        response.then().statusCode(201);

        System.out.println(response.asString());

        Assert.assertEquals(response.asString(), "Created");

        System.out.println("Booking deleted successfully.");

        //Assert.assertTrue(bookingId > 0, "Booking ID should be greater than 0");

        // String firstName = response.jsonPath().getString("booking.firstname");
        // String lastName = response.jsonPath().getString("booking.lastname");
        // int totalPrice = response.jsonPath().getInt("booking.totalprice");

        // Assert.assertEquals(firstName, booking.getFirstname());
        // Assert.assertEquals(lastName, booking.getLastname());
        // Assert.assertEquals(totalPrice, booking.getTotalprice());

       // System.out.println("Deleted  successfully.");
    }
    
}

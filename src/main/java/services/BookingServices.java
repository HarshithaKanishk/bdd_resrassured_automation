package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import endpoints.Routes;

public class BookingServices {

    public static Response createBooking(Object bookingJsonPath) {
        // Booking booking = JsonUtil.readJsonFile(bookingJsonPath, Booking.class);

        // Booking booking = JsonUtil.readJsonFile(Constants.CREATE_BOOKING_JSON_PATH,
        // Booking.class);

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bookingJsonPath)
                .when()
                .post(Routes.BOOKING)
                .then()
                .extract()
                .response();
        // Implementation for creating a booking
    }

    public static Response getBooking(int bookingId) {
        return RestAssured.given()
                .pathParam("id", bookingId)
                .when()
                .get(Routes.BOOKING_ID)
                .then()
                .extract()
                .response();
        // Implementation for retrieving a booking by ID
    }

    public static Response updateBooking(int bookingId, String token, Object updateJsonPath) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .pathParam("id", bookingId)
                .body(updateJsonPath)
                .when()
                .put(Routes.BOOKING_ID)
                .then()
                .extract()
                .response();
        // Implementation for updating a booking by ID
    }

    public static Response deleteBooking(int bookingId, String token) {
        return RestAssured.given()
                .header("Cookie", "token=" + token)
                .pathParam("id", bookingId)
                .when()
                .delete(Routes.BOOKING_ID)
                .then()
                .extract()
                .response();
        // Implementation for deleting a booking by ID
    }

}

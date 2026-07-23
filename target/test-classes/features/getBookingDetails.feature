Feature: Get Booking Details

  Scenario: Get booking details successfully

    Given User has booking details
    And User creates a booking
    When User retrieves the booking details
    Then User should receive the booking details successfully
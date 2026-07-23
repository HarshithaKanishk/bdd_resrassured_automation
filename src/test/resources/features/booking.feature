Feature: Create Booking

  Scenario: Create a new booking successfully

    Given User has booking details
    When User creates a booking
    Then Booking should be created successfully
Feature: Delete Booking

  Scenario: Delete the booking successfully

    Given User has booking details for delete
    Then Booking should be deleted successfully
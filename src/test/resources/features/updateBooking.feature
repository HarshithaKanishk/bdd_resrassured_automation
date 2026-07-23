Feature: Update Booking

Scenario: Update the booking successfully

  Given User has booking details for update
  When User update a booking
  Then Booking should be updated successfully
Feature: Booking
  Scenario: booking with valid data
    #When User select random destination
    #When user select valid country
    When User select "دبي"
    And User select random arrival and Departure dates
    And User open rooms dropdown menu
    And User add another room with 1 child
    And click on Apply button
    Then check the number of the booked rooms
    And click on searchOnHotels button
    Then print the number of available hotels and their data
    When Go to the star rating and choose "3" stars.
    And Sort hotels by cheapest
    And Peak hotel number 1 from the list
    Then Verify that the check in, check out date is correct
    And Verify that guests and room numbers are correct
    When User select first room option and continue to checkout
    Then Verify that reservation summary is present


Feature: Booking Feature
  Scenario: verify that user can book the hotel successfully
    Given User should fill the destination
    When user should fill check in and check out dates
    And select room with a child
    And select room without children
    Then click on apply button
    And The number of rooms chosen must be two
    When click on search hotels button
    And  print the number of available hotels
    Then user go to the star rating and choose three stars
    When user Sorts the hotels by cheapest and select the cheapest
    And verify that the chosen data
    And click on customize room and continue to checkout
    Then make sure reservation summary is present.




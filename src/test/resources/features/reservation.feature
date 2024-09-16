Feature: Reservation
  Scenario: Create reserve
    Given that I access the reservibe restaurant api
    When I do a reserve
    Then the return must be "200" success
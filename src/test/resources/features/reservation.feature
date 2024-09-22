Feature: Reservation
  Scenario: Create reserve
    Given that I register a reservation
    Then the return must be "200" success
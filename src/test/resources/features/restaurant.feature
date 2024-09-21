Feature: Restaurant

  Scenario: Register restaurant
    Given I create a restaurant
    Then the return must be "200"
    #schema

  Scenario: Register restaurant without tables
    Given I create a restaurant without tables
    Then the return must be "400"
    #schema

  Scenario Template: Read restaurant by city
    Given that there is a saved restaurant
    When I look for a restaurant by "<city>"
    Then the return must be "200" success
    And the restaurant must be presented
    Examples:
     |city   |
     |name   |

  Scenario Template: Read restaurant by address
    Given that there is a saved restaurant
    When I look for a restaurant by "<address>"
    Then the return must be "200" success
    And the restaurant must be presented
    Examples:
      |address   |
      |name   |

  Scenario Template: Read restaurant by cuisine
    Given that there is a saved restaurant
    When I look for a restaurant by "<cuisine>"
    Then the return must be "200" success
    And the restaurant must be presented
    Examples:
      |cuisine   |
      |name   |

  Scenario Template: Read restaurant by name
    Given that there is a saved restaurant
    When I look for a restaurant by "<name>"
    Then the return must be "200" success
    And the restaurant must be presented
    Examples:
      |name   |
      |name   |

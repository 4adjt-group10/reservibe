Feature: Restaurant

 Scenario Template: Register restaurant
    Given I create a restaurant with "<name>" and "<city>" and "<cuisine>"
    Then the return must be "200"
   Examples:
     |name         |city     |cuisine|
     |Restaurante 1|São Paulo|TURKISH|
     |Restaurante 2|São Paulo|INDIAN|
     |Restaurante 3|Rio de Janeiro|ITALIAN|

  Scenario: Register restaurant without tables
    Given I create a restaurant without tables
    Then the return must be "400"

  Scenario Template: Read restaurant by city
    Given I create a restaurant with "<name>" and "<city>" and "<cuisine>"
    When I look for a restaurant by city
    Then the return must be "200"
    And the restaurants city should be like "<city>"
    Examples:
      |name         |city     |cuisine|
      |Restaurante 4|São Paulo|TURKISH|
      |Restaurante 5|Campos do Jordão|FRENCH|


  Scenario: Read restaurant by address
    Given that there is a saved restaurant
    When I look for a restaurant by address
    Then the return must be "200"


  Scenario Template: Read restaurant by cuisine
    Given I create a restaurant with "<name>" and "<city>" and "<cuisine>"
    When I look for a restaurant by cuisine
    Then the return must be "200"
    Examples:
      |name         |city     |cuisine|
      |Restaurante 10|São Paulo|TURKISH|
      |Restaurante 20|Jacutinga|JAPANESE|


  Scenario Template: Read restaurant by name
    Given I create a restaurant with "<name>" and "<city>" and "<cuisine>"
    When I look for a restaurant by name
    Then the return must be "200"
    Examples:
      |name           |city     |cuisine|
      |Restaurante 13 |São Paulo|TURKISH|
      |Restaurante 215|Serra Negra|CHINESE|


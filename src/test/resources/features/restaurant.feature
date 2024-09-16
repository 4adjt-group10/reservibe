Feature: Restaurant

 Scenario Template: Register restaurant with
    Given that I access the reservibe restaurant api
    When I put "<name>", "<address>", "<phonenumber>", "<description>", "<cuisine>", "<openingHours>" and "<tables>"
    Then the return must be "201" success
    And the restaurant must be presented
   Examples:
     | name | address | phonenumber | description | cuisine | openingHours | tables |

  Scenario Template: Register restaurant without tables
    Given that I access the reservibe restaurant api
    When I put "<name>", "<address>", "<phonenumber>", "<description>", "<cuisine>", "<openingHours>"
    Then the return must be "400" unsuccess
    Examples:
      | name | address | phonenumber | description | cuisine | openingHours |


  Scenario Template: Read restaurant by type
    Given that there is a saved restaurant
    When I look for a restaurant by "<type>"
    Then the return must be "200" success
    And the restaurant must be presented
    Examples:
      |type   |
      |name   |
      |address|
      |cuisine|

  Scenario: Read all restaurants
    Given that there are some saved restaurants
    When I look for all restaurant
    Then the return must be "200" success
    And all restaurants must be presented

  #Scenario: Update restaurant
    #Given that there is a saved restaurant
    #When I update the restaurant
    #Then the return must be "200" success
    #And the restaurant must be presented

  Scenario: Delete restaurant
    Given that there is a saved restaurant
    When I delete a restaurant
    Then the return must be "204" success
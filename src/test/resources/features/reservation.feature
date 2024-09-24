#Feature: Reservation
#
#  Scenario Template: Reserve free tables
#    Given I create a restaurant with "<name>" and "<city>" and "<cuisine>" and "<statusMesa1>" and "<statusMesa2>"
#    And I look for the restaurant
#    And I try to reserve the FREE table
#    Then the return reservation must be "200"
#    Examples:
#      | name          | city    |cuisine|statusMesa1|statusMesa2|
#      |Restaurante 200|São Paulo|TURKISH|FREE       |FREE       |
#      |Restaurante 203|São Paulo|TURKISH|FREE       |FREE       |
#
#
#  #Scenario Template: reserve tables by type
#    #Given Given that there is a saved restaurant
#    #When I look for a table by "<type>"
#    #Then the return must be "200" success
#    #And the table must be presented
#
#    #Examples:
#      #|type  |
#      #|date  |
#      #|time  |
#
#  #Scenario: read tables reserved
#    #Given that there is a reserved tables
#    #When I look for all tables
#    #Then the return must be "200" success
#    #And the table must be with reserved status
#

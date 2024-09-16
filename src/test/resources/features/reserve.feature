Feature: Reserve
  Scenario Template: reserve tables by type
    Given that there are some saved tables
    When I look for a table by "<type>"
    Then the return must be "200" success
    And the table must be presented

    Examples:
      |type  |
      |date  |
      |time  |

  Scenario: read tables reserved
    Given that there is a reserved tables
    When I look for all tables
    Then the return must be "200" success
    And the table must be with reserved status


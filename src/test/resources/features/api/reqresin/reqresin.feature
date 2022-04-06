@adit
Feature: Reqresin

  Scenario: Success GET users
    When user send GET Users request to reqresin
#    Then response status code should be 200
#    And response path "page" should contain Int value "2"
#    And response path "per_page" should contain Int value "6"
#    And response path "data[1].first_name" should contain String value "Lindsay"
#    And response path "data[1].last_name" should contain String value "Ferguson"

  Scenario: Success POST login
    When user send POST login request to reqresin
#    Then response status code should be 200

  Scenario: Success PUT update
    When user send PUT Update request to reqresin
#    Then response status code should be 200
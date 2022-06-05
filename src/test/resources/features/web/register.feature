@web @register @staging @ALT-123
Feature: Register

  @positive @web-1
  Scenario: Success Register
    And user input email data
    And user input password data
    And user input address data
    When user click register button
    Then user should be redirected to homepage

  @negative @exclude @expired @web-2
  Scenario: Failed Register
    And user input email data
    And user input password data
    When user click register button
    Then user should be able to see warning message

  @positive @web-3
  Scenario: Register using google account
    When user click register with "google"
    Then user should redirected to "google" page

  @positive @web-4
  Scenario: Register using facebook account
    When user click register with "facebook"
    Then user should redirected to "facebook" page
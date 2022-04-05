@register @staging @ALT-123
Feature: Register

  @positive
  Scenario: Success Register
    And user input email data
    And user input password data
    And user input address data
    When user click register button
    Then user should be redirected to homepage

  @negatif
  Scenario: Failed Register
    And user input email data
    And user input password data
    When user click register button
    Then user should be able to see warning message

  @positive
  Scenario: Register using google account
    When user click register with "google"
    Then user should redirected to "google" page

  @positive
  Scenario: Register using facebook account
    When user click register with "facebook"
    Then user should redirected to "facebook" page
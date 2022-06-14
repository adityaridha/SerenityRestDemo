@web @register @staging @ALT-123
Feature: Register Website 2

  @positive @web-1
  Scenario: Success Register 2
    And user input email data
    And user input password data
    And user input address data
    When user click register button
    Then user should be redirected to homepage

  @negative @exclude @expired @web-2
  Scenario: Failed Register 2
    And user input email data
    And user input password data
    When user click register button
    Then user should be able to see warning message

  @positive @web-3
  Scenario: Register using google account 2
    When user click register with "Adit account"
    Then user should redirected to "Adit" page

  @positive @web-4 @exclude
  Scenario: Register using facebook account 2
    When user click register with "facebook"
    Then user should redirected to "facebook" page

  Scenario: Demo step baru 2
    When bikin step baru
    And ini step baru lagi

  Scenario: input data 2
    Given user input data "Sebuah Data"
    And user input angka 6

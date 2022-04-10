@reqresin
Feature: Reqresin

  @get-user
  Scenario: Success GET users
    When user send GET Users request to reqresin
    Then response status code should be 200
    And response structure should match json schema "users.json"

  @post-login @positif
  Scenario: Success POST login
    When user send POST login request to reqresin with body json "success-login.json"
    Then response status code should be 200
    And response structure should match json schema "login.json"

  @post-login @negatif
  Scenario: Failed POST login
    When user send POST login request to reqresin with body json "failed-login.json"
    Then response status code should be 400

  @put-update
  Scenario: Success PUT update
    When user send PUT Update request to reqresin
    Then response status code should be 200
    And response structure should match json schema "update-user.json"

  @post-register
  Scenario: Post Register
    When user send POST Register request to reqresin
    Then response status code should be 200
    And response structure should match json schema "register.json"
@reqres
Feature: Reqres API

  Scenario: GET list users
    When user send GET list user request
    Then response status code should be 200
    And response body with jsonPath "data.id" should be equal 2
    And response body with jsonPath "data.email" should be equal "janet.weaver@reqres.in"
    And response body should be equal with jsonSchema "single-user.json"

  Scenario: POST success login
    When user send POST login request with body "success-login.json"
    Then response status code should be 200
    And response body with jsonPath "token" should have type String
    And response body should be equal with jsonSchema "login.json"

  Scenario: POST failed login
    When user send POST login request with body "failed-login.json"
    Then response status code should be 400
    And response body with jsonPath "error" should be equal "Missing password"
    And response body should be equal with jsonSchema "login-failed.json"
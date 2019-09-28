@login
Feature: Login to Mercury demo tours site
  1. User should Not be able to login to the application with invalid credentials
  2. User should be able to login to the application with valid credentials

  Scenario: Login with Invalid credentials
    Given The user opens Movie Rental site
    When Admin user logins
    Then add movie page is open


  Scenario Outline: Login with Valid credentials
    Given The user opens Movie Rental site
    When The user enters "<user_name>" and "<password>" and click on login button
    Then add movie page is open

    Examples: 
      | user_name | password |
      | user   | password  |

@login
Feature: Login to Mercury demo tours site
  1. User should Not be able to login to the application with invalid credentials
  2. User should be able to login to the application with valid credentials


  Scenario Outline: Login with user
    Given The user opens Movie Rental site
    When The user enters "<user_name>" and "<password>" and click on login button
    Then verify "<user_name>" in user profile

    Examples: 
      | user_name | password |
      | user   | password  |

@login
Feature: Login to Mercury demo tours site
  1. User should Not be able to login to the application with invalid credentials
  2. User should be able to login to the application with valid credentials

  Scenario Outline: Login with Invalid credentials
    Given The user opens mercury tour demo site
    When The user enters '<user_name>' and '<password>' and click on login button
    Then The home page should not be displayed

    Examples: 
      | user_name | password |
      | test      | test     |

  Scenario Outline: Login with Valid credentials
    Given The user opens mercury tour demo site
    When The user enters '<user_name>' and '<password>' and click on login button
    Then The home page should be displayed

    Examples: 
      | user_name | password |
      | mercury   | mercury  |

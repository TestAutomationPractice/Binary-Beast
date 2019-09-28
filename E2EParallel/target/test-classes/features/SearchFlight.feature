 @Smoke1 
Feature: Login to Mercury demo tours site and search for a flight
  1. User should be able to login to the application and search for a One way flight
  2. User should be able to login to the application and search for a Round trip flight
  

  Scenario Outline: Search a Round trip flight
    Given The user opens mercury tour demo site
    When The user enters '<user_name>' and '<password>' and clicks on login button
    And User enters Flight details and clicks Continue
      | Fields         | Values        |
      | TripType       | roundtrip     |
      | Passanger      |             1 |
      | DepartingFrom  | Frankfurt     |
      | MonthOn        | March         |
      | FromDay        |            22 |
      | ArrivingIn     | Paris         |
      | ReturningMonth | March         |
      | ReturningDay   |            28 |
      | ServClass      | Business      |
      | Airline        | No Preference |
    Then User is Navigated to Select Flight page

    Examples: 
      | user_name | password |
      | mercury   | mercury  |
  

  Scenario Outline: Search a One way flight
    Given The user opens mercury tour demo site
    When The user enters '<user_name>' and '<password>' and clicks on login button
    And User enters Flight details and clicks Continue
      | Fields         | Values        |
      | TripType       | oneway        |
      | Passanger      |             1 |
      | DepartingFrom  | London        |
      | MonthOn        | March         |
      | FromDay        |            20 |
      | ArrivingIn     | Paris         |
      | ReturningMonth | NA            |
      | ReturningDay   | NA            |
      | ServClass      | Business      |
      | Airline        | No Preference |
    Then User is Navigated to Select Flight page

    Examples: 
      | user_name | password |
      | mercury   | mercury  |

  
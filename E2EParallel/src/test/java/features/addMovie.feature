@AddMovie
Feature: Add Movie when logged in with Admin
  1. User should be able to Add movie
  
  
   Scenario Outline: Add a Movie
    Given The admin open Movie Rental site
    When Admin user login
    When Admin adds movie with "<Title>", "<Director>","<Description>","<Categories>","<ImageURL>","<Rating>"
    Then verify Movie with "<Title>" is added successfully

    Examples: 
      | Title      | Director      | Description        | Categories | ImageURL                                                                                                                 |Rating|
      | Chhichhore10 | Nitesh Talwar | Great Comedy Movie | Comedy     | https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP |4| 
 
  

  Scenario Outline: Add a Movie and Verify parallelly
    Given The user opens Movie Rental site
    When The user enters user details and click on login button
      | user     | user     |
      | password | password |
    And The admin open Movie Rental site Parallely
    And Admin user login
    When Admin adds movie with "<Title>", "<Director>","<Description>","<Categories>","<ImageURL>","<Rating>"
    Then verify Movie with "<Title>" is added successfully

    Examples: 
      | Title       | Director      | Description        | Categories | ImageURL                                                                                                                 | Rating |
      | Chhichhore20 | Nitesh Talwar | Great Comedy Movie | Comedy     | https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP |      4 |

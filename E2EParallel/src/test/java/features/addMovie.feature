@AddMovie
Feature: Add Movie when logged in with Admin
  1. User should be able to Add movie
 
 @tag1
  Scenario Outline: Add a Customer
    Given The user opens Movie Rental site
    When Admin user logins
    When User adds movie with "<Title>", "<Director>","<Description>","<Categories>","<ImageURL>","<Rating>"
    Then Movie is added successfully

    Examples: 
      | Title      | Director      | Description        | Categories | ImageURL                                                                                                                 |Rating|
      | Chhichhore | Nitesh Talwar | Great Comedy Movie | Comedy     | https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP |4| 
 

    
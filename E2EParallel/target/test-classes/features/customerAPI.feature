@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Add a Customer
    Given User want to add a new customer
    When Customer details are "<firstName>" and "<lastName>" and "<userName>" and "<password>"
    Then Customer is added successfully

     Examples: 
      | firstName | lastName | userName   | password |
      | Ram       | Kapoor   | RamKapoor  | Ram123   |
      | Shyan     | Mehta    | ShyamMehra | Shyam123 |



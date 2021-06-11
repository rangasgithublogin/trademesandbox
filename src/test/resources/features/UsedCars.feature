Feature: Used Cars Info
  Scenario: Verify Used Cars Info
    Given I navigate to trademe sandbox
    When I search for used cars
    Then the Used Cars listing is displayed
    And I verify the queried car's info
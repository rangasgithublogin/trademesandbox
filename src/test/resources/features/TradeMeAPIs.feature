Feature: Test TradeMe Public APIs
  Scenario: Verify GET Response
    Given I build the Public GET API Request for Charities to return json response
    When I call the given method
    Then the json response has the expected data St John

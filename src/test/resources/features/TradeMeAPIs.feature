Feature: Test TradeMe Public APIs

  Scenario Outline: Verify GET Response
    Given I build the Public GET API Request for Charities to return <FileFormat> response
    When I call the given method
    Then the <FileFormat> response has the expected data <Charity>
    Examples:
      | FileFormat | Charity |
      | json       | St John |
      | xml        | Plunket |

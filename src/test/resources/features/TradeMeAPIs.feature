Feature: Test TradeMe Public APIs

  Scenario Outline: Verify GET Response
    Given I build the Public GET API Request for <ServiceName> to return <FileFormat> response
    When I call the given method
    Then the <FileFormat> response has the expected data: <Data> given by the Service <ServiceName>
    Examples:
      | FileFormat | ServiceName         | Data    |
      | json       | Charities           | St John |
      | json       | Charities           | Plunket |
      | json       | Categories/UsedCars | Ford    |
      | json       | Categories/UsedCars | Hummer  |

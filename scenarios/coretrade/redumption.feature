Feature: Redumption feature
  @smoke
  @dataFile:data/testdata.csv
  @filter:scenarioOrTestCaseId=='sc-456'
  @testcaseId:sc-456
  Scenario: Data driven: Redumption verification
    Given 'Step-1': User with account '${data}'

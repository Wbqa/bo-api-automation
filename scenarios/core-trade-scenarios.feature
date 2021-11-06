Feature: Core Trade User Accounts
  @regression
  Scenario: Static Data: Users Account Verification
    Given User with account 12345
    Then Fetch account details 12345
    Then Verify user account number matches with 12345

  @smoke
  @dataFile:data/accounts.csv
  Scenario: Data driven: Users Account Verification
    Given User with account '${account}'
    Then Fetch account details '${account}'
    Then Verify user account number matches with '${account}'
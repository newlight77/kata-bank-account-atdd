Feature: Bank account creation
  A client wants to create a bank account

  Scenario: Create an account with money
    Given a client who's name is <name>
    And he has <money> in his wallet
    When he want to create a bank account with his money
    Then the account is created under his name with an initial balance of <money>

    |name|money|
    |kong|100  |
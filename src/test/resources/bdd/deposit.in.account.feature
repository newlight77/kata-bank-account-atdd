Feature: Deposit in Bank Account
  A client wants to deposit his money in his account

  Scenario Outline: Deposit money with positif amount
    Given a client having an account
    And the balance in that account is <init_balance>
    And he has <money> in his wallet
    When he want to deposit his pocket money in his account
    Then the new balance is updated with <balance>

    Examples:
    | init_balance | money   | balance |
    | 100          | 50      | 150.0   |

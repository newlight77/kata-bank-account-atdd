package bdd;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefsBankAccountCreation {

    @Given("^a client who's lastname is (.*) and firstname is (.*)$")
    public void a_client_who_s_lastname_is_and_firstname_is(String lastname, String firstname) throws Exception {
        throw new PendingException();
    }

    @Given("^he has (.*) in his wallet$")
    public void he_has_in_his_wallet(int money) throws Exception {
        throw new PendingException();
    }

    @When("^he want to create a bank account with his money$")
    public void he_want_to_create_a_bank_account_with_his_money() throws Exception {
        throw new PendingException();
    }

    @Then("^the account is created under his name with an initial balance of (.*)$")
    public void the_account_is_created_under_his_name_with_an_initial_balance_of(int balance, DataTable dataTable) throws Exception {
        throw new PendingException();
    }

}

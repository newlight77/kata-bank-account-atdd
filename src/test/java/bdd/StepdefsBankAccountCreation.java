package bdd;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.service.AccountService;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class StepdefsBankAccountCreation {

    private AccountService accountService = new AccountService();
    private Client client;
    private Account account;

    @Given("^a client who's lastname is (.*) and firstname is (.*)$")
    public void a_client_who_s_lastname_is_and_firstname_is(String lastname, String firstname) throws Exception {
        client = Client.builder()
                .lastname(lastname)
                .firstname(firstname)
                .build();
    }

    @Given("^he has (\\d+.\\d+) in his wallet$")
    public void he_has_in_his_wallet(double money) throws Exception {
        client.setWallet(money);
    }

    @When("^he want to create a bank account with his money$")
    public void he_want_to_create_a_bank_account_with_his_money() throws Exception {
        account = accountService.create(client);
    }

    @Then("^the account is created under his name with an initial balance of (\\d+.\\d+)$")
    public void the_account_is_created_under_his_name_with_an_initial_balance_of(double balance) throws Exception {
        Assertions.assertThat(account).isNotNull();
        Assertions.assertThat(account.getBalance()).isEqualTo(balance);
    }

}

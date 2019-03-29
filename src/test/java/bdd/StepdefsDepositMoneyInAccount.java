package bdd;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import com.newlight77.kata.bank.model.CreationStatus;
import com.newlight77.kata.bank.service.AccountService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class StepdefsDepositMoneyInAccount {

    private AccountService accountService = new AccountService();
    private Client client;
    private CreationStatus creationStatus;

    @Given("^a client having an account$")
    public void a_client_having_an_account() throws Exception {
        client = Client.builder()
                .lastname("lastname")
                .firstname("firstname")
                .country(Country.FRANCE)
                .build();
        creationStatus = accountService.create(client);
    }

    @Given("^the balance in that account is (\\d+)$")
    public void the_balance_in_that_account_is(int initial_balance) throws Exception {
        creationStatus.getAccount().setBalance(initial_balance);
    }

    @Given("^he has (\\d+) in his wallet$")
    public void he_has_in_his_wallet(int money) throws Exception {
        client.setWallet(money);
    }

    @When("^he want to deposit his pocket money in his account$")
    public void he_want_to_deposit_his_pocket_money_in_his_account() throws Exception {
        accountService.deposit(client.getWallet());
    }

    @Then("^the new balance is updated with (\\d+.\\d+)$")
    public void the_new_balance_is_updated_with(double balance) throws Exception {
        Assertions.assertThat(creationStatus.getAccount().getBalance()).isEqualTo(balance);
    }
}

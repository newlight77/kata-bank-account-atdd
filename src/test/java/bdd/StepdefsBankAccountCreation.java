package bdd;

import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import com.newlight77.kata.bank.model.CreationStatus;
import com.newlight77.kata.bank.service.AccountService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class StepdefsBankAccountCreation {

    private AccountService accountService = new AccountService();
    private Client client;
    private CreationStatus creationStatus;

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

    @Given("^he lives in (.*)")
    public void he_lives_in(String country) throws Exception {
        client.setCountry(Country.valueOf(country));
    }

    @When("^he want to create a bank account with his money$")
    public void he_want_to_create_a_bank_account_with_his_money() throws Exception {
        creationStatus = accountService.create(client);
    }

    @Then("^the account is created under his name with an initial balance of (\\d+.\\d+)$")
    public void the_account_is_created_under_his_name_with_an_initial_balance_of(double balance) throws Exception {
        Assertions.assertThat(creationStatus).isNotNull();
        Assertions.assertThat(creationStatus.isCreated()).isTrue();
        Assertions.assertThat(creationStatus.getAccount()).isNotNull();
        Assertions.assertThat(creationStatus.getAccount().getBalance()).isEqualTo(balance);
    }

    @Then("^the account is not created$")
    public void the_account_is_not_created() throws Exception {
        Assertions.assertThat(creationStatus).isNotNull();
        Assertions.assertThat(creationStatus.isCreated()).isFalse();
    }

    @Then("^an no allowed is shown$")
    public void an_no_allowed_is_shown() throws Exception {
        Assertions.assertThat(creationStatus).isNotNull();
        Assertions.assertThat(creationStatus.getErrorMessage()).isNotEqualTo("not allowed");
    }
}

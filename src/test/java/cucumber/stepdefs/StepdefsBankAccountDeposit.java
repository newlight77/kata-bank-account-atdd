package cucumber.stepdefs;

import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.Country;
import com.newlight77.kata.bank.model.CreationStatus;
import com.newlight77.kata.bank.model.NotAllowedOperationException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import static cucumber.stepdefs.StepDefsBankAccountContext.CONTEXT;

public class StepdefsBankAccountDeposit {

    private StepDefsBankAccountContext context = CONTEXT;

    @Given("^a client having an account$")
    public void a_client_having_an_account() throws Exception {
        Client client = Client.builder()
                .lastname("lastname")
                .firstname("firstname")
                .country(Country.FRANCE)
                .build();
        CreationStatus creationStatus = context.getAccountService().create(client);
        context.setClient(client);
        context.setCreationStatus(creationStatus);
    }

    @Given("^the balance in that account is (\\-?\\d*\\.?\\d+)$")
    public void the_balance_in_that_account_is(double initial_balance) throws Exception {
        context.getCreationStatus().getAccount().setBalance(initial_balance);
    }

    @When("^he want to deposit his pocket money in his account$")
    public void he_want_to_deposit_his_pocket_money_in_his_account() throws Exception {
        Throwable thrown = Assertions.catchThrowable(() -> {
            context.getAccountService().deposit(
                    context.getCreationStatus().getAccount(),
                    context.getClient().getWallet()
            );
        });
        context.setThrowable(thrown);
    }

    @Then("^the new balance is updated with (\\-?\\d*\\.?\\d+)$")
    public void the_new_balance_is_updated_with(double balance) throws Exception {
        Assertions.assertThat(context.getCreationStatus().getAccount().getBalance()).isEqualTo(balance);
    }

    @Then("^the deposit is not allowed$")
    public void the_deposit_is_not_allowed() throws Exception {
        Assertions.assertThat(context.getThrowable())
                .isInstanceOf(NotAllowedOperationException.class);
    }

    @Then("^An error operation not allowed is displayed$")
    public void an_error_operation_not_allowed_is_displayed() throws Exception {

        Assertions.assertThat(context.getThrowable())
                .isInstanceOf(NotAllowedOperationException.class)
                .hasMessage("operation not allowed");
    }
}

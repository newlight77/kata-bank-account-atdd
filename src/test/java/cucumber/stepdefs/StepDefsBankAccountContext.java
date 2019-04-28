package cucumber.stepdefs;

import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.CreationStatus;
import com.newlight77.kata.bank.service.AccountService;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum StepDefsBankAccountContext {

    CONTEXT;

    private final ThreadLocal<Map<String, Object>> payloads = ThreadLocal.withInitial(HashMap::new);

    private AccountService accountService = new AccountService();

    public Client getClient() {
        return Client.class.cast(payloads.get()
                .get(Client.class.getName()));
    }

    public void setClient(Client client) {
        payloads.get()
                .put(Client.class.getName(), client);
    }

    public CreationStatus getCreationStatus() {
        return CreationStatus.class.cast(payloads.get()
                .get(CreationStatus.class.getName()));
    }

    public void setCreationStatus(CreationStatus status) {
        payloads.get()
                .put(CreationStatus.class.getName(), status);
    }

    public Throwable getThrowable() {
        return Throwable.class.cast(payloads.get()
                .get(Throwable.class.getName()));
    }

    public void setThrowable(Throwable throwable) {
        payloads.get()
                .put(Throwable.class.getName(), throwable);
    }

    public <T> T getPayload(Class<T> clazz) {
        return clazz.cast(payloads.get()
                .get(clazz.getName()));
    }

    public <T> void setPayload(T object) {
        payloads.get()
                .put(object.getClass().getName(), object);
    }

    public void reset() {
        payloads.get()
                .clear();
    }
}

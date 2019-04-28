package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.model.*;

public class AccountService {

    public CreationStatus create(Client client) {
        Account account = new Account(client, client.getWallet());

        if (Country.FRANCE.equals(client.getCountry())) {
            return CreationStatus.builder()
                    .account(account)
                    .created(true)
                    .build();
        }

        return CreationStatus.builder()
                .account(account)
                .created(false)
                .build();
    }

    public void deposit(Account account, double money) {
        if (money < 0) {
            throw new NotAllowedOperationException("operation not allowed");
        }
        account.setBalance(account.getBalance()+money);
    }
}

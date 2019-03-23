package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;
import com.newlight77.kata.bank.model.CreationStatus;

public class AccountService {
    public CreationStatus create(Client client) {
        Account account = new Account(client, client.getWallet());
        return CreationStatus.builder()
                .account(account)
                .created(true)
                .build();
    }
}

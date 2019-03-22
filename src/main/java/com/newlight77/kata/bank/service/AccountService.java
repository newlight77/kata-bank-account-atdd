package com.newlight77.kata.bank.service;

import com.newlight77.kata.bank.model.Account;
import com.newlight77.kata.bank.model.Client;

public class AccountService {
    public Account create(Client client) {
        Account account = new Account(client, client.getWallet());
        return account;
    }
}

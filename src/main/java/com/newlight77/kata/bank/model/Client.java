package com.newlight77.kata.bank.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private String firstname;
    private String lastname;
    private String country;
    private double wallet;
}

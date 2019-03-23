package com.newlight77.kata.bank.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreationStatus {
    private boolean created;
    private Account account;
    private String errorMessage;
}

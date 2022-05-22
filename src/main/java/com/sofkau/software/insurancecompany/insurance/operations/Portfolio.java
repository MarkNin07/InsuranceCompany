package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.software.insurancecompany.insurance.operations.values.BankAccount;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;

import java.util.Objects;

public class Portfolio extends Entity<PortfolioId> {

    private BankAccount bankAccount;
    private Email email;

    public Portfolio(PortfolioId portfolioId, BankAccount bankAccount, Email email) {
        super(portfolioId);
        this.bankAccount = bankAccount;
        this.email = email;
    }

    public Portfolio(PortfolioId portfolioId){
        super(portfolioId);
    }


    public void updatePortfolioEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }

    public BankAccount bankAccount() {
        return bankAccount;
    }

    public Email email() {
        return email;
    }
}

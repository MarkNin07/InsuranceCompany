package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.BankAccount;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;

public class AddPortfolio extends Command {


    private final OperationsId operationsId;
    private final PortfolioId portfolioId;
    private final BankAccount bankAccount;
    private final Email email;

    public AddPortfolio(OperationsId operationsId, PortfolioId portfolioId, BankAccount bankAccount, Email email) {
        this.operationsId = operationsId;
        this.portfolioId = portfolioId;
        this.bankAccount = bankAccount;
        this.email = email;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public PortfolioId portfolioId() {
        return portfolioId;
    }

    public BankAccount bankAccount() {
        return bankAccount;
    }

    public Email email() {
        return email;
    }
}

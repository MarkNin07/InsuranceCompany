package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.BankAccount;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;

public class PortfolioAdded extends DomainEvent {

    private final OperationsId operationsId;
    private final PortfolioId portfolioId;
    private final BankAccount bankAccount;
    private final Email email;

    public PortfolioAdded(OperationsId operationsId, PortfolioId portfolioId, BankAccount bankAccount, Email email) {
        super("marconino.operations.portfolioadded");
        this.operationsId = operationsId;
        this.portfolioId = portfolioId;
        this.bankAccount = bankAccount;
        this.email = email;
    }

    public OperationsId getOperationsId() {
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

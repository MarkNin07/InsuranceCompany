package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;

public class PortfolioEmailUpdated extends DomainEvent {


    private final OperationsId operationsId;
    private final PortfolioId portfolioId;
    private final Email email;

    public PortfolioEmailUpdated(OperationsId operationsId, PortfolioId portfolioId, Email email) {
        super("marconino.operations.portfolioemailupdated");
        this.operationsId = operationsId;
        this.portfolioId = portfolioId;
        this.email = email;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public PortfolioId portfolioId() {
        return portfolioId;
    }

    public Email email() {
        return email;
    }
}

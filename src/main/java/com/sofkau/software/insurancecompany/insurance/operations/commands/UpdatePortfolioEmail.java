package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;

public class UpdatePortfolioEmail extends Command {

    private final OperationsId operationsId;
    private final PortfolioId portfolioId;
    private final Email email;

    public UpdatePortfolioEmail(OperationsId operationsId, PortfolioId portfolioId, Email email) {
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

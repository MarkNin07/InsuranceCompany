package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddPortfolio;

public class AddPortfolioUseCase extends UseCase<RequestCommand<AddPortfolio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPortfolio> addPortfolioRequestCommand) {
        var command = addPortfolioRequestCommand.getCommand();
        var operation = Operations.from(command.operationsId(), retrieveEvents(command.operationsId().value()));
        operation.addPortfolio(command.operationsId(), command.portfolioId(), command.bankAccount(), command.email());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));
    }
}

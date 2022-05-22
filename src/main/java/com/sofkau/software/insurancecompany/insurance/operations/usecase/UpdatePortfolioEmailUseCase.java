package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.UpdatePortfolioEmail;

public class UpdatePortfolioEmailUseCase extends UseCase<RequestCommand<UpdatePortfolioEmail>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePortfolioEmail> updatePortfolioEmailRequestCommand) {
        var command = updatePortfolioEmailRequestCommand.getCommand();
        var operation = Operations.from(command.operationsId(), retrieveEvents(command.operationsId().value()));
        operation.updatePortfolioEmail(command.operationsId(), command.portfolioId(), command.email());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));
    }
}

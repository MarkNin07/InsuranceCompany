package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.CreateOperation;

public class CreateOperationUseCase extends UseCase<RequestCommand<CreateOperation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateOperation> createOperationRequestCommand) {
        var command = createOperationRequestCommand.getCommand();
        var operation = new Operations(command.operationsId(), command.type());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));
    }
}

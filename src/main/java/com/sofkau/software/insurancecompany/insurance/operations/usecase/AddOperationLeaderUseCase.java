package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddOperationLeader;

public class AddOperationLeaderUseCase extends UseCase<RequestCommand<AddOperationLeader>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddOperationLeader> addOperationLeaderRequestCommand) {
        var command = addOperationLeaderRequestCommand.getCommand();
        var operation = Operations.from(command.operationsId(), retrieveEvents(command.operationsId().value()));
        operation.addOperationLeader(command.operationsId(), command.managerId(), command.managerName());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));
    }
}

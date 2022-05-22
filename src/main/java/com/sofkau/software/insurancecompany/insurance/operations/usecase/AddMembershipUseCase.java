package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddMembership;

public class AddMembershipUseCase extends UseCase<RequestCommand<AddMembership>, ResponseEvents>{


    @Override
    public void executeUseCase(RequestCommand<AddMembership> addMembershipRequestCommand) {
        var command = addMembershipRequestCommand.getCommand();
        var operation = Operations.from(command.operationsId(), retrieveEvents(command.operationsId().value()));
        operation.addMembership(command.operationsId(), command.membershipId(), command.phoneNumber(), command.email());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));

    }
}

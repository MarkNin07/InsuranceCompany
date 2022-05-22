package com.sofkau.software.insurancecompany.insurance.operations.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.software.insurancecompany.insurance.operations.Operations;
import com.sofkau.software.insurancecompany.insurance.operations.commands.UpdateOperationLeader;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationLeaderUpdated;

public class UpdateOperationLeaderUseCase  extends UseCase<TriggeredEvent<OperationLeaderUpdated>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<OperationLeaderUpdated> operationLeaderUpdatedTriggeredEvent) {
        var event = operationLeaderUpdatedTriggeredEvent.getDomainEvent();
        var operation = Operations.from(event.operationsId(), retrieveEvents(event.operationsId().value()));
        operation.updateOperationLeader(event.operationsId(), event.managerId(), event.managerName());
        emit().onResponse(new ResponseEvents(operation.getUncommittedChanges()));
    }
}

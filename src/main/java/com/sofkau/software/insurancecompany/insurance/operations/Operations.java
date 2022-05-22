package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

import java.util.List;
import java.util.Set;

public class Operations extends AggregateEvent<OperationsId> {


    protected Type type;
    protected Set<OperationManager> operationManager;
    protected Set<Portfolio> portfolio;
    protected Set<Membership> memberships;

    public Operations(OperationsId operationsId, Type type) {
        super(operationsId);
        appendChange(new OperationCreated(type)).apply();
    }

    public Operations(OperationsId operationsId) {
        super(operationsId);
        subscribe(new UpdateOperations(this));
    }

    public static Operations from(OperationsId operationsId, List<DomainEvent> events){
        Operations operations = new Operations(operationsId);
        events.forEach((event) -> operations.applyEvent(event));
        return operations;
    }


    public Type type() {
        return type;
    }
}

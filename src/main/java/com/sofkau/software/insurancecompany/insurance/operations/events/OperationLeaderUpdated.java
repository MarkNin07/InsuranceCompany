package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class OperationLeaderUpdated extends DomainEvent {


    private final OperationsId operationsId;
    private final ManagerId managerId;
    private final Name managerName;

    public OperationLeaderUpdated(OperationsId operationsId, ManagerId managerId, Name managerName) {
        super("marconino.operations.operationleaderupdated");
        this.operationsId = operationsId;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public ManagerId managerId() {
        return managerId;
    }

    public Name managerName() {
        return managerName;
    }
}

package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class UpdateOperationLeader extends Command {


    private final OperationsId operationsId;
    private final ManagerId managerId;
    private final Name managerName;

    public UpdateOperationLeader(OperationsId operationsId, ManagerId managerId, Name managerName) {
        this.operationsId = operationsId;
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public OperationsId getOperationsId() {
        return operationsId;
    }

    public ManagerId getManagerId() {
        return managerId;
    }

    public Name getManagerName() {
        return managerName;
    }
}

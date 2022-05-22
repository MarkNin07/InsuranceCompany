package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class AddOperationLeader extends Command {

    private final OperationsId operationsId;
    private final ManagerId managerId;
    private final Name managerName;

    public AddOperationLeader(OperationsId operationsId, ManagerId managerId, Name managerName) {
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

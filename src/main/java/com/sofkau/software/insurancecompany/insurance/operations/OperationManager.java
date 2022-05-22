package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

import java.util.Objects;

public class OperationManager  extends Entity<ManagerId> {


    private Name managerName;

    public OperationManager(ManagerId managerId, Name managerName) {
        super(managerId);
        this.managerName = managerName;
    }

    public OperationManager(ManagerId managerId){
        super(managerId);
    }

    public void updateOperationLeader(Name managerName){
        this.managerName = Objects.requireNonNull(managerName);
    }

    public Name managerName() {
        return managerName;
    }
}

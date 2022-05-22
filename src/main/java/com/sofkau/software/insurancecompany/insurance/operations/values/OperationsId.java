package com.sofkau.software.insurancecompany.insurance.operations.values;

import co.com.sofka.domain.generic.Identity;

public class OperationsId extends Identity {

    public OperationsId(String uuid) {
        super(uuid);
    }

    public OperationsId() {
    }

    public static OperationsId of(String id){
        return new OperationsId(id);
    }

}

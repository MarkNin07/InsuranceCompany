package com.sofkau.software.insurancecompany.insurance.operations.values;

import co.com.sofka.domain.generic.Identity;

public class ManagerId extends Identity {

    public ManagerId(String uuid) {
        super(uuid);
    }

    public ManagerId() {
    }

    public static ManagerId of(String id){
        return new ManagerId(id);
    }

}

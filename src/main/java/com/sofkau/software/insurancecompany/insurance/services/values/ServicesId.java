package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.Identity;

public class ServicesId extends Identity {

    public ServicesId() {
    }

    private ServicesId(String uuid) {
        super(uuid);
    }

    public static ServicesId of(String id){
        return new ServicesId(id);
    }



}

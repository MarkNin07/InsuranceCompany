package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.Identity;

public class DisResId extends Identity {

    public DisResId() {
    }

    private DisResId(String uuid) {
        super(uuid);
    }

    public static DisResId of(String id){
        return new DisResId(id);
    }

}

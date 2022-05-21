package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.Identity;

public class ReservesId extends Identity {

    private ReservesId(String uuid) {
        super(uuid);
    }

    public ReservesId() {
    }

    public static ReservesId of(String id){
        return new ReservesId(id);
    }

}

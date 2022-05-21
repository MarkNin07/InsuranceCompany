package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.Identity;

public class LeaderId extends Identity {

    private LeaderId(String uuid) {
        super(uuid);
    }

    public LeaderId() {
    }

    public static LeaderId of(String id){
        return new LeaderId(id);
    }

}

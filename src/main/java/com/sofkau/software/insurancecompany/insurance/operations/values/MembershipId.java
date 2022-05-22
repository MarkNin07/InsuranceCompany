package com.sofkau.software.insurancecompany.insurance.operations.values;

import co.com.sofka.domain.generic.Identity;

public class MembershipId  extends Identity {

    public MembershipId(String uuid) {
        super(uuid);
    }

    public MembershipId() {
    }

    public static MembershipId of(String id){
        return new MembershipId(id);
    }

}

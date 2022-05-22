package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

import java.util.Objects;

public class PreventionLeader extends Entity<LeaderId> {


    private Name leaderName;

    public PreventionLeader(LeaderId leaderId, Name leaderName) {
        super(leaderId);
        this.leaderName = leaderName;
    }

    public PreventionLeader(LeaderId leaderId){
        super(leaderId);
    }

    public void updatePreventionLeader(Name leaderName){
        this.leaderName = Objects.requireNonNull(leaderName);
    }

    public Name leaderName() {
        return leaderName;
    }
}

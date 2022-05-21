package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class PreventionLeader extends Entity<LeaderId> {


    private Name leaderName;

    public PreventionLeader(LeaderId leaderId, Name leaderName) {
        super(leaderId);
        this.leaderName = leaderName;
    }

    public Name getLeaderName() {
        return leaderName;
    }
}

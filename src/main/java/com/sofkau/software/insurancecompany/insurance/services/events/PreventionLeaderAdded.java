package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class PreventionLeaderAdded extends DomainEvent {

    private final LeaderId leaderId;
    private final Name leaderName;

    public PreventionLeaderAdded(LeaderId leaderId, Name leaderName) {
        super("marconino.services.preventionleaderadded");
        this.leaderId = leaderId;
        this.leaderName = leaderName;
    }

    public LeaderId getLeaderId() {
        return leaderId;
    }

    public Name getLeaderName() {
        return leaderName;
    }
}

package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class PreventionLeaderUpdated extends DomainEvent {

    private final LeaderId leaderId;
    private final Name leaderName;

    public PreventionLeaderUpdated(LeaderId leaderId, Name leaderName) {
        super("marconino.services.preventionleaderupdated");
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

package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class PreventionLeaderUpdated extends DomainEvent {


    private final ServicesId servicesId;
    private final LeaderId leaderId;
    private final Name leaderName;

    public PreventionLeaderUpdated(ServicesId servicesId, LeaderId leaderId, Name leaderName) {
        super("marconino.services.preventionleaderupdated");
        this.servicesId = servicesId;
        this.leaderId = leaderId;
        this.leaderName = leaderName;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public LeaderId getLeaderId() {
        return leaderId;
    }

    public Name getLeaderName() {
        return leaderName;
    }
}

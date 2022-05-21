package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;

public class UpdatePreventionLeader extends Command {


    private final ServicesId servicesId;
    private final LeaderId leaderId;
    private final Name leaderName;

    public UpdatePreventionLeader(ServicesId servicesId, LeaderId leaderId, Name leaderName) {
        this.servicesId = servicesId;
        this.leaderId = leaderId;
        this.leaderName = leaderName;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public LeaderId leaderId() {
        return leaderId;
    }

    public Name leaderName() {
        return leaderName;
    }
}

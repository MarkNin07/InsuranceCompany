package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.PreventionLeader;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class AddPreventionLeader extends Command {

    private final ServicesId servicesId;
    private final LeaderId leaderId;
    private PreventionLeader preventionLeader;

    public AddPreventionLeader(ServicesId servicesId, LeaderId leaderId) {
        this.servicesId = servicesId;
        this.leaderId = leaderId;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public LeaderId leaderId() {
        return leaderId;
    }

    public PreventionLeader preventionLeader() {
        return preventionLeader;
    }
}

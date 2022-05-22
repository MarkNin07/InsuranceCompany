package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddPreventionLeader;

public class AddPreventionLeaderUseCase extends UseCase<RequestCommand<AddPreventionLeader>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPreventionLeader> addPreventionLeaderRequestCommand) {
        var command = addPreventionLeaderRequestCommand.getCommand();
        var services = Services.from(command.servicesId(), retrieveEvents(command.servicesId().value()));
        services.addPreventionLeader(command.servicesId(), command.leaderId(), command.leaderName() );
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));
    }
}

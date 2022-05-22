package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddDisabilityReserve;

public class AddDisabilityReserveUseCase extends UseCase<RequestCommand<AddDisabilityReserve>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDisabilityReserve> addDisabilityReserveRequestCommand) {
        var command = addDisabilityReserveRequestCommand.getCommand();
        var services = Services.from(command.servicesId(), retrieveEvents(command.servicesId().value()));
        services.addDisabilityReserve(command.disResId(), command.disabled(), command.payments());
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));
    }
}

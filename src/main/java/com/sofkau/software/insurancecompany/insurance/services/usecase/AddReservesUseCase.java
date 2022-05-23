package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddReserves;

public class AddReservesUseCase extends UseCase<RequestCommand<AddReserves>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddReserves> addReservesRequestCommand) {
        var command = addReservesRequestCommand.getCommand();
        var services = Services.from(command.servicesId(), this.retrieveEvents());
        services.addReserves(command.reservesId(), command.isAffiliated(), command.medicalEvaluation(), command.disabilityTime());
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));
    }
}

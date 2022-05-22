package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddReserves;
import com.sofkau.software.insurancecompany.insurance.services.commands.CreateService;

public class CreateServiceUseCase extends UseCase<RequestCommand<CreateService>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateService> createServiceRequestCommand) {
        var command = createServiceRequestCommand.getCommand();
        var services = new Services(command.servicesId(), command.type());
    }
}

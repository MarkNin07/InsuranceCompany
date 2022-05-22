package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.UpdateDisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityTimeUpdated;

public class UpdateDisabilityTimeUseCase extends UseCase<TriggeredEvent<DisabilityTimeUpdated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DisabilityTimeUpdated> disabilityTimeUpdatedTriggeredEvent) {
        var event = disabilityTimeUpdatedTriggeredEvent.getDomainEvent();
        var services = Services.from(event.servicesId(), retrieveEvents(event.servicesId().value()));
        services.updateDisabilityTime(event.servicesId(), event.getReservesId(), event.getDisabilityTime());
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));
    }
}

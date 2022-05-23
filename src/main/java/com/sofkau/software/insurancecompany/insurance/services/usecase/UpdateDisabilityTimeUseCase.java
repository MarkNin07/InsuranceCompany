package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityTimeUpdated;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;

public class UpdateDisabilityTimeUseCase extends UseCase<TriggeredEvent<DisabilityTimeUpdated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DisabilityTimeUpdated> disabilityTimeUpdatedTriggeredEvent) {
        var event = disabilityTimeUpdatedTriggeredEvent.getDomainEvent();
        var services = Services.from(event.servicesId(), this.retrieveEvents());
        services.sendPayment(event.servicesId(), DisResId.of("123"), new Payments("1000"));
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));
    }
}

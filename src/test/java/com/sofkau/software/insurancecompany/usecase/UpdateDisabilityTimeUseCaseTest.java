package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.software.insurancecompany.insurance.services.commands.UpdateDisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityReserveAdded;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityTimeUpdated;
import com.sofkau.software.insurancecompany.insurance.services.events.PaymentSent;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.UpdateDisabilityTimeUseCase;
import com.sofkau.software.insurancecompany.insurance.services.values.*;
import com.sofkau.software.insurancecompany.insurance.shared.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class UpdateDisabilityTimeUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private UpdateDisabilityTimeUseCase useCase;
    @Test
    void updateDisTimeTest(){

        var triggerEvent = new DisabilityTimeUpdated(ServicesId.of("707"), new ReservesId(), new DisabilityTime("45"));
        var eventAggCreated = new ServiceCreated(new Type("update disability time"));
        var eventEntCreated = new DisabilityReserveAdded(DisResId.of("605"), new IsDisabled("true"), new Payments("750"));
        eventAggCreated.setAggregateRootId("707");
        eventEntCreated.setAggregateRootId("605");
        when(repository.getEventsBy("707")).thenReturn(List.of(eventAggCreated, eventEntCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("707")
                .syncExecutor(useCase, new TriggeredEvent<>(triggerEvent))
                .orElseThrow(() -> new IllegalArgumentException("unable to generate a payment"))
                .getDomainEvents();

        var event = (PaymentSent) events.get(0);
        Assertions.assertEquals("1000", event.getPayment().value());

    }
}

package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddReserves;
import com.sofkau.software.insurancecompany.insurance.services.events.ReservesAdded;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.AddReservesUseCase;
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
public class AddReservesUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private AddReservesUseCase useCase;
    @Test
    void addResvTest(){

        var command = new AddReserves(ServicesId.of("317"), new ReservesId(), new IsAffiliated("false"), new MedicalEvaluation("flu"), new DisabilityTime("30"));
        var eventAggCreated = new ServiceCreated(new Type("Service"));
        eventAggCreated.setAggregateRootId("317");
        when(repository.getEventsBy("317")).thenReturn(List.of(eventAggCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("317")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Add Reserves failed"))
                .getDomainEvents();

        var event = (ReservesAdded) events.get(0);
        Assertions.assertEquals(command.reservesId().value(), event.reservesId().value());
        Assertions.assertEquals(command.isAffiliated().value(), event.isAffiliated().value());
        Assertions.assertEquals(command.medicalEvaluation().value(), event.medicalEvaluation().value());
        Assertions.assertEquals(command.disabilityTime().value(), event.disabilityTime().value());

    }

}

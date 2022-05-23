package com.sofkau.software.insurancecompany.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.services.DisabilityReserve;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddDisabilityReserve;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityReserveAdded;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.AddDisabilityReserveUseCase;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
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
public class AddDisabilityReserveUseCaseTest {



    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private AddDisabilityReserveUseCase useCase;
    @Test
    void addDisResvTest(){
        var command = new AddDisabilityReserve(ServicesId.of("7"), DisResId.of("12"), new IsDisabled("false"), new Payments("1000"));
        var eventAggCreated = new ServiceCreated(new Type("disability reserve"));
        eventAggCreated.setAggregateRootId("7");
        when(repository.getEventsBy("7")).thenReturn(List.of(eventAggCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("7")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Check your disability reserve"))
                .getDomainEvents();

        var event = (DisabilityReserveAdded)events.get(0);
        Assertions.assertEquals(command.disResId().value(), event.disResId().value());
        Assertions.assertEquals(command.disabled().value(), event.isDisabled().value());
        Assertions.assertEquals(command.payments().value(), event.payments().value());

    }

}

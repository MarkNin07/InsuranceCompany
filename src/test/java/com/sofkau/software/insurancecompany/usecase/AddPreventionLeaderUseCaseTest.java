package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddPreventionLeader;
import com.sofkau.software.insurancecompany.insurance.services.events.PreventionLeaderAdded;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.AddPreventionLeaderUseCase;
import com.sofkau.software.insurancecompany.insurance.services.values.LeaderId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Name;
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
public class AddPreventionLeaderUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private AddPreventionLeaderUseCase useCase;
    @Test
    void addPrevLeaderTest(){

        var command = new AddPreventionLeader(ServicesId.of("316"), new LeaderId(), new Name("Mel"));
        var eventAggCreated = new ServiceCreated(new Type("Mel"));
        eventAggCreated.setAggregateRootId("316");
        when(repository.getEventsBy("316")).thenReturn(List.of(eventAggCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("316")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Add prevention leader failed"))
                .getDomainEvents();

        var event = (PreventionLeaderAdded) events.get(0);
        Assertions.assertEquals(command.servicesId().value(), event.servicesId().value());
        Assertions.assertEquals(command.leaderId().value(), event.leaderId().value());
        Assertions.assertEquals(command.leaderName().value(), event.leaderName().value());

    }

}

package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddOperationLeader;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationLeaderAdded;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.AddOperationLeaderUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
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
public class AddOperationLeaderUseCaseTest {

    @Mock
    private DomainEventRepository repo;
    @InjectMocks
    private AddOperationLeaderUseCase useCase;
    @Test
    void addOperLeaderTest(){

        var command = new AddOperationLeader(OperationsId.of("410"), new ManagerId("2112"), new Name("Jz"));
        var eventAggCreat = new OperationCreated(new Type("Add new operation leader"));
        eventAggCreat.setAggregateRootId("410");
        when(repo.getEventsBy("410")).thenReturn(List.of(eventAggCreat));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("410")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Add operation leader failed"))
                .getDomainEvents();

        var event = (OperationLeaderAdded) events.get(0);
        Assertions.assertEquals(command.operationsId().value(), event.operationsId().value());
        Assertions.assertEquals(command.managerId().value(), event.managerId().value());
        Assertions.assertEquals(command.managerName().value(), event.managerName().value());

    }
}

package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationLeaderAdded;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationLeaderUpdated;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.UpdateOperationLeaderUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.ManagerId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.services.events.DisabilityReserveAdded;
import com.sofkau.software.insurancecompany.insurance.shared.Name;
import com.sofkau.software.insurancecompany.insurance.shared.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class UpdateOperationLeaderUseCaseTest {

    private final String updateOperationID = "7";

    @Mock
    private DomainEventRepository repository;
    @Test
    void updateOperLeader(){

        var eventUpdate = new OperationLeaderUpdated(OperationsId.of(updateOperationID), ManagerId.of("745"), new Name("Steve"));
        var useCase = new UpdateOperationLeaderUseCase();
        Mockito.when(repository.getEventsBy(updateOperationID)).thenReturn(List.of(
                new OperationCreated(new Type("update operation leader")),
                new OperationLeaderAdded(OperationsId.of("8"), ManagerId.of("634"), new Name("Jerry"))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(updateOperationID)
                .syncExecutor(useCase, new TriggeredEvent<>(eventUpdate))
                .orElseThrow(() -> new IllegalArgumentException("Check your operation leader updated"))
                .getDomainEvents();

        var event = (OperationLeaderUpdated)events.get(0);
        Assertions.assertEquals(eventUpdate.operationsId().value(), event.operationsId().value());
        Assertions.assertEquals(eventUpdate.managerId().value(), event.managerId().value());
        Assertions.assertEquals(eventUpdate.managerName().value(), event.managerName().value());

    }

}

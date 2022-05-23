package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddPortfolio;
import com.sofkau.software.insurancecompany.insurance.operations.commands.UpdatePortfolioEmail;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.events.PortfolioEmailUpdated;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.UpdatePortfolioEmailUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.*;
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
public class UpdatePortfolioEmailUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private UpdatePortfolioEmailUseCase useCase;
    @Test
    void updateOpLeaderTest(){

        var command = new UpdatePortfolioEmail(OperationsId.of("430"), new PortfolioId(), new Email("m345"));
        var eventAggCreated = new OperationCreated(new Type("update portfolio email"));
        var eventEntCreated = new PortfolioEmailUpdated(OperationsId.of("310"), new PortfolioId(), new Email("jgalz"));
        eventAggCreated.setAggregateRootId("430");
        eventEntCreated.setAggregateRootId("310");
        when(repository.getEventsBy("430")).thenReturn(List.of(eventAggCreated, eventEntCreated));


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("430")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("update portfolio failed"))
                .getDomainEvents();

        var event = (PortfolioEmailUpdated) events.get(0);
        Assertions.assertEquals(command.operationsId().value(), event.operationsId().value());
        Assertions.assertEquals(command.portfolioId().value(), event.portfolioId().value());
        Assertions.assertEquals(command.email().value(), event.email().value());


    }
}

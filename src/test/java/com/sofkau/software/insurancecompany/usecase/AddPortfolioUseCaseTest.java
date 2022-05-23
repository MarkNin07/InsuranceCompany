package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddPortfolio;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.events.PortfolioAdded;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.AddPortfolioUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.BankAccount;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PortfolioId;
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
public class AddPortfolioUseCaseTest {

    @Mock
    private DomainEventRepository repo;
    @InjectMocks
    private AddPortfolioUseCase useCase;
    @Test
    void addPortfTest(){

        var command = new AddPortfolio(OperationsId.of("420"), new PortfolioId(), new BankAccount("33456"), new Email("gb@cm"));
        var eventAggCreated = new OperationCreated(new Type("Create new portfolio"));
        eventAggCreated.setAggregateRootId("420");
        when(repo.getEventsBy("420")).thenReturn(List.of(eventAggCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("420")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("new portfolio failed"))
                .getDomainEvents();

        var event = (PortfolioAdded) events.get(0);
        Assertions.assertEquals(command.portfolioId().value(), event.portfolioId().value());
        Assertions.assertEquals(command.bankAccount().value(), event.bankAccount().value());
        Assertions.assertEquals(command.email().value(), event.email().value());

    }

}

package com.sofkau.software.insurancecompany.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.operations.commands.CreateOperation;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.CreateOperationUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CreateOperationUseCaseTest {

    private CreateOperationUseCase useCase;

    @Test
    void createOperationTest(){

        var command = new CreateOperation(OperationsId.of("312"), new Type("portfolio"));
        useCase =new CreateOperationUseCase();

        var eventsDriver = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("312")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Create operation failed"))
                .getDomainEvents();

        var event = (OperationCreated) eventsDriver.get(0);
        Assertions.assertEquals(command.type().value(), event.getType().value());

    }

}

package com.sofkau.software.insurancecompany.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.services.commands.CreateService;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.CreateServiceUseCase;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateServiceUseCaseTest {

    private CreateServiceUseCase usecase;




    @Test
    void createServiceTest(){
        //arrange
        var command = new CreateService(ServicesId.of("12345"), new Type("reserve"));
        usecase = new CreateServiceUseCase();

        //Act
        var eventsDriver = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("12345")
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("You must be kidding?"))
                .getDomainEvents();
        //assert
        var event = (ServiceCreated) eventsDriver
                .get(0);
        Assertions.assertEquals(command.type().value(), event.getType().value());

    }



}

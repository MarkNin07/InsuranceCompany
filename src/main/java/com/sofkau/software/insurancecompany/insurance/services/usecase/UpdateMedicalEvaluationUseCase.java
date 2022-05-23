package com.sofkau.software.insurancecompany.insurance.services.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.commands.AddDisabilityReserve;
import com.sofkau.software.insurancecompany.insurance.services.commands.UpdateMedicalEvaluation;

public class UpdateMedicalEvaluationUseCase extends UseCase<RequestCommand<UpdateMedicalEvaluation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateMedicalEvaluation> updateMedicalEvaluationRequestCommand) {
        var command = updateMedicalEvaluationRequestCommand.getCommand();
        var services = Services.from(command.servicesId(), this.retrieveEvents());
        services.updateMedicalEvaluation(command.servicesId(), command.reservesId(), command.medicalEvaluation());
        emit().onResponse(new ResponseEvents(services.getUncommittedChanges()));

    }
}

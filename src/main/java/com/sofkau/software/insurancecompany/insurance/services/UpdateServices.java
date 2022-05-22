package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.software.insurancecompany.insurance.services.events.*;

import java.util.HashSet;

public class UpdateServices extends EventChange {


    public UpdateServices(Services services) {
        apply((ServiceCreated event) -> {
            services.type = event.getType();
            services.preventionLeader = new HashSet<>();
            services.reserves = new HashSet<>();
            services.disabilityReserve = new HashSet<>();

        });

        apply((ReservesAdded event) -> {
            services.reserves.add(new Reserves(event.reservesId(), event.isAffiliated(), event.medicalEvaluation(), event.disabilityTime()));
        });

        apply((DisabilityTimeUpdated event) -> {
            var reserve = new Reserves(event.getReservesId());
            reserve.updateDisabilityTime(event.getDisabilityTime());
        });

        apply((DisabilityReserveAdded event) -> {
            services.disabilityReserve.add(new DisabilityReserve(event.disResId(), event.isDisabled(), event.payments()));
        });

        apply((MedicalEvaluationUpdated event) -> {
            var reserve = new Reserves(event.getReservesId());
            reserve.updateMedicalEvaluation(event.getMedicalEvaluation());
        });

        apply((PaymentSent event) -> {
            var disReserv = new DisabilityReserve(event.getDisResId());
            disReserv.sendPayment(event.getPayment());
        });

        apply((PreventionLeaderAdded event) -> {
            services.preventionLeader.add(new PreventionLeader(event.leaderId(), event.leaderName()));
        });

        apply((PreventionLeaderUpdated event) -> {
            var prevLeader = new PreventionLeader(event.getLeaderId());
            prevLeader.updatePreventionLeader(event.getLeaderName());
        });

        apply((UserStateChecked event) -> {
            var reserve = new Reserves(event.getReservesId());
            reserve.checkUserState(event.getIsAffiliated());
        });
    }


}

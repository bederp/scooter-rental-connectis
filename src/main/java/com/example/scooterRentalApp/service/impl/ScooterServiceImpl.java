package com.example.scooterRentalApp.service.impl;

import com.example.scooterRentalApp.api.request.AddScooterRequest;
import com.example.scooterRentalApp.api.response.AddScooterResponse;
import com.example.scooterRentalApp.common.MsgSource;
import com.example.scooterRentalApp.exception.CommonBadRequestException;
import com.example.scooterRentalApp.exception.CommonConflictException;
import com.example.scooterRentalApp.model.Scooter;
import com.example.scooterRentalApp.model.ScooterDock;
import com.example.scooterRentalApp.repository.ScooterDockRepository;
import com.example.scooterRentalApp.repository.ScooterRepository;
import com.example.scooterRentalApp.service.AbstractCommonService;
import com.example.scooterRentalApp.service.ScooterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static com.example.scooterRentalApp.common.ValidationUtils.*;

@Service
public class ScooterServiceImpl extends AbstractCommonService implements ScooterService {

    private ScooterRepository scooterRepository;
    private ScooterDockRepository scooterDockRepository;

    public ScooterServiceImpl(
            MsgSource msgSource,
            ScooterRepository scooterRepository,
            ScooterDockRepository scooterDockRepository
    ) {
        super(msgSource);
        this.scooterRepository = scooterRepository;
        this.scooterDockRepository = scooterDockRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<AddScooterResponse> addScooter(AddScooterRequest request) {
        validateAddScooterRequest(request);
        ScooterDock scooterDock = extractDockFromRepository(request.getScooterDockId());
        checkIsAvailablePlaceInDock(scooterDock);
        Scooter addedScooter = addScooterToDataSource(request, scooterDock);
        return ResponseEntity.ok(new AddScooterResponse(msgSource.OK003, addedScooter.getId()));
    }

    private void validateAddScooterRequest(AddScooterRequest request) {
        if (isNullOrEmpty(request.getModelName())
                || isNull(request.getRentalPrice())
                || isNull(request.getMaxSpeed())
                || isNull(request.getScooterDockId())) {

            throw new CommonBadRequestException(msgSource.ERR001);
        }

        if (isUncorrectedMaxSpeed(request.getMaxSpeed())) {
            throw new CommonConflictException(msgSource.ERR007);
        }
    }

    private ScooterDock extractDockFromRepository(Long scooterDockId) {
        Optional<ScooterDock> optionalScooterDock = scooterDockRepository.findById(scooterDockId);
        if (!optionalScooterDock.isPresent()) {
            throw new CommonConflictException(msgSource.ERR008);
        }
        return optionalScooterDock.get();
    }

    private void checkIsAvailablePlaceInDock(ScooterDock scooterDock) {
        if (scooterDock.getAvailablePlace()<= scooterDock.getScooters().size()) {
            throw new CommonConflictException(msgSource.ERR009);
        }
    }

    private Scooter addScooterToDataSource(AddScooterRequest request, ScooterDock scooterDock) {
        Scooter scooter = new Scooter();
        scooter.setModelName(request.getModelName());
        scooter.setMaxSpeed(request.getMaxSpeed());
        scooter.setRentalPrice(new BigDecimal(request.getRentalPrice()));
        scooter.setScooterDock(scooterDock);

        return scooterRepository.save(scooter);
    }
}



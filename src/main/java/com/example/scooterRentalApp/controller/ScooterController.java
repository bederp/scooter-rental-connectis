package com.example.scooterRentalApp.controller;

import com.example.scooterRentalApp.api.request.AddScooterRequest;
import com.example.scooterRentalApp.api.response.AddScooterResponse;
import com.example.scooterRentalApp.service.ScooterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scooter")
public class ScooterController {

    private ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<AddScooterResponse> addScooter(
            @RequestBody AddScooterRequest request
    ) {
        return scooterService.addScooter(request);
    }
}

package com.example.scooterRentalApp.service;

import com.example.scooterRentalApp.model.Scooter;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ScooterDockService {

    ResponseEntity<Set<Scooter>> getAllDockScooters(Long scooterDockId);
}

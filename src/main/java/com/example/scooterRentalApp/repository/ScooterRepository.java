package com.example.scooterRentalApp.repository;

import com.example.scooterRentalApp.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}

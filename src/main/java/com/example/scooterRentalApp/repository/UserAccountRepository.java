package com.example.scooterRentalApp.repository;

import com.example.scooterRentalApp.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    List<UserAccount> findByOwnerEmail(String ownerEmail);
}

package com.example.scooterRentalApp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ownerEmail;
    private String ownerUsername;
    private Integer ownerAge;
    private BigDecimal balance;
    private LocalDateTime createdDate;

    @OneToOne(mappedBy = "userAccount")
    private Scooter scooter;

    public UserAccount() {}

    public UserAccount(Long id, String ownerEmail, String ownerUsername, Integer ownerAge, BigDecimal balance, LocalDateTime createdDate) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.ownerUsername = ownerUsername;
        this.ownerAge = ownerAge;
        this.balance = balance;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public Integer getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(Integer ownerAge) {
        this.ownerAge = ownerAge;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }
}

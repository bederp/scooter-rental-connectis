package com.example.scooterRentalApp.api.request;

public class AddScooterRequest {

    private String modelName;
    private Integer maxSpeed;
    private Double rentalPrice;
    private Long scooterDockId;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Long getScooterDockId() {
        return scooterDockId;
    }

    public void setScooterDockId(Long scooterDockId) {
        this.scooterDockId = scooterDockId;
    }
}

package com.example.scooterRentalApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ScooterDock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dockName;
    private Integer availablePlace;

    @OneToMany(mappedBy = "scooterDock", cascade = CascadeType.ALL)
    private Set<Scooter> scooters;

    @Override
    public String toString() {
        return "ScooterDock{" +
                "id=" + id +
                ", dockName='" + dockName + '\'' +
                ", availablePlace='" + availablePlace + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDockName() {
        return dockName;
    }

    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    public Integer getAvailablePlace() {
        return availablePlace;
    }

    public void setAvailablePlace(Integer availablePlace) {
        this.availablePlace = availablePlace;
    }

    public Set<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(Set<Scooter> scooters) {
        this.scooters = scooters;
    }
}

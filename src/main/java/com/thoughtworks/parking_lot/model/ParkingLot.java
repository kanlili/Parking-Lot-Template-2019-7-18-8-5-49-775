package com.thoughtworks.parking_lot.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@SpringBootApplication
@Entity
public class ParkingLot{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(nullable = false)
  private String name;
  private Integer capacity;
  private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ParkingLot(String name, Integer capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }
}

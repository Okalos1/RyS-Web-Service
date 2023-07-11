package com.aca.rystransportes.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "units")
public class Units implements Serializable
{
    @Id
    @Column(name = "plate")
    String plate;

    @Column(name = "brand")
    String brand;

    @Column(name = "model")
    String model;

    @Column(name = "gpsid")
    String gpsid;

    //Constructors
    public Units() {
        super();
    }

    public Units(String plate, String brand, String model, String gpsid) {
        super();
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.gpsid = gpsid;
    }

    //Getters and setters

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGpsid() {
        return gpsid;
    }

    public void setGpsid(String gpsid) {
        this.gpsid = gpsid;
    }
}

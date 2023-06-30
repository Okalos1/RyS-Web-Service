package com.aca.rystransportes.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "freights")
public class Freights
{

    //TODO: create freights foreign key from client
    //TODO: create freights foreign key from units
    //TODO: established One to Many connection to EmployeeFreight

    @Id
    @Column(name = "idfreight")
    Integer idFreight;

    Date date;

    String client;

    String tonage;

    String unit;

    String destination;

    String type;

    String shipment;

    String comments;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTonage() {
        return tonage;
    }

    public void setTonage(String tonage) {
        this.tonage = tonage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

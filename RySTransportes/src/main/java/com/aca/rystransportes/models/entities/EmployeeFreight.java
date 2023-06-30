package com.aca.rystransportes.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employeefreight")
public class EmployeeFreight {

    @Id
    @Column(name = "idemployeefreight")
    Integer idEmployeeFreight;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "dui")
    User user;

    //@ManyToOne
    //Freight freight;

    String position;

    float payment;

    float viatic;

    @Column(name = "extrapayment")
    float extraPayment;

    public Integer getIdEmployeeFreight() {
        return idEmployeeFreight;
    }

    public void setIdEmployeeFreight(Integer idEmployeeFreight) {
        this.idEmployeeFreight = idEmployeeFreight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getViatic() {
        return viatic;
    }

    public void setViatic(float viatic) {
        this.viatic = viatic;
    }

    public float getExtraPayment() {
        return extraPayment;
    }

    public void setExtraPayment(float extraPayment) {
        this.extraPayment = extraPayment;
    }
}

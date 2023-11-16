package com.aca.rystransportes.models.dtos;

import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.models.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class EmpFreightInfo {

    @NotBlank
    private Integer freight;

    @NotBlank
    private String position;

    @NotBlank
    private float payment;

    @NotBlank
    private float viatic;

    @NotBlank
    private float extraPayment;

    @NotBlank
    private Date freightdate;
    
    @NotBlank
    private String user;

    //Constructors

    public EmpFreightInfo() {
        super();
    }

	public EmpFreightInfo(@NotBlank Integer freight, @NotBlank String position, @NotBlank float payment,
			@NotBlank float viatic, @NotBlank float extraPayment, @NotBlank Date freightdate, @NotBlank String user) {
		super();
		this.freight = freight;
		this.position = position;
		this.payment = payment;
		this.viatic = viatic;
		this.extraPayment = extraPayment;
		this.freightdate = freightdate;
		this.user = user;
	}



	public Integer getFreight() {
		return freight;
	}

	public void setFreight(Integer freight) {
		this.freight = freight;
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

	public Date getFreightdate() {
		return freightdate;
	}

	public void setFreightdate(Date freightdate) {
		this.freightdate = freightdate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    
}

package com.gestionhotel.mvc.entites;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tarif implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id_Tarif;
	private double TaxeSejour;
	private double PetitDej;
	private double LitSupp;
	private double LitBebe;



	
	@OneToOne(cascade = {CascadeType.ALL})
	private Facture facture;
	
	

	public Tarif(double taxeSejour, double petitDej, double litSupp, double litBebe, Facture facture) {
		super();
		TaxeSejour = taxeSejour;
		PetitDej = petitDej;
		LitSupp = litSupp;
		LitBebe = litBebe;
		this.facture = facture;
	}



	public Tarif() {
	super();
}



	public Long getId_Tarif() {
		return id_Tarif;
	}



	public void setId_Tarif(Long id_Tarif) {
		this.id_Tarif = id_Tarif;
	}



	public double getTaxeSejour() {
		return TaxeSejour;
	}



	public void setTaxeSejour(double taxeSejour) {
		TaxeSejour = taxeSejour;
	}



	public double getPetitDej() {
		return PetitDej;
	}



	public void setPetitDej(double petitDej) {
		PetitDej = petitDej;
	}



	public double getLitSupp() {
		return LitSupp;
	}



	public void setLitSupp(double litSupp) {
		LitSupp = litSupp;
	}



	public double getLitBebe() {
		return LitBebe;
	}



	public void setLitBebe(double litBebe) {
		LitBebe = litBebe;
	}



	public Facture getFacture() {
		return facture;
	}



	public void setFacture(Facture facture) {
		this.facture = facture;
	}
}

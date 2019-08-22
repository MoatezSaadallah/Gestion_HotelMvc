package com.gestionhotel.mvc.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id_Facture;
	private Date date_Facture;
	private double Montant;
	private Long FPetitDej;
	private Long FLitSupp;
	private Long FLitBebe;

	@OneToOne(cascade = {CascadeType.ALL})
	private Client client;
	@OneToOne(cascade = {CascadeType.ALL})
	private Tarif tarif;
	
	
	
	public Facture() {
		super();
	}


	
	
	
	
	
	public Facture(Date date_Facture, double montant, Long fPetitDej, Long fLitSupp, Long fLitBebe, Client client,
			Tarif tarif) {
		super();
		this.date_Facture = date_Facture;
		Montant = montant;
		FPetitDej = fPetitDej;
		FLitSupp = fLitSupp;
		FLitBebe = fLitBebe;
		this.client = client;
		this.tarif = tarif;
	}







	public Long getFPetitDej() {
		return FPetitDej;
	}







	public void setFPetitDej(Long fPetitDej) {
		FPetitDej = fPetitDej;
	}







	public Long getFLitSupp() {
		return FLitSupp;
	}







	public void setFLitSupp(Long fLitSupp) {
		FLitSupp = fLitSupp;
	}







	public Long getFLitBebe() {
		return FLitBebe;
	}







	public void setFLitBebe(Long fLitBebe) {
		FLitBebe = fLitBebe;
	}







	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Tarif getTarif() {
		return tarif;
	}
	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}
	public Long getId_Facture() {
		return id_Facture;
	}
	public void setId_Facture(Long id_Facture) {
		this.id_Facture = id_Facture;
	}
	public Date getDate_Facture() {
		return date_Facture;
	}
	public void setDate_Facture(Date date_Facture) {
		this.date_Facture = date_Facture;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	
	
}

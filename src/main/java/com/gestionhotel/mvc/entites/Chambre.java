package com.gestionhotel.mvc.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Chambre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id_Chambre;
	private Long nbr_Place;
	private String Etat;
	private String Type;
	@OneToOne(cascade = {CascadeType.MERGE})
	private Reservation reservation;
	private double tarif;
	
	public Chambre() {
		super();
	}

	public Chambre(Long id_Chambre, Long nbr_Place, String etat, String type, Reservation reservation, double tarif) {
		super();
		this.id_Chambre = id_Chambre;
		this.nbr_Place = nbr_Place;
		Etat = etat;
		Type = type;
		this.reservation = reservation;
		this.tarif = tarif;
	}



	public Reservation getReservation() {
		return reservation;
	}



	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}



	public double getTarif() {
		return tarif;
	}



	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public Long getId_Chambre() {
		return id_Chambre;
	}

	public void setId_Chambre(Long id_Chambre) {
		this.id_Chambre = id_Chambre;
	}

	public Long getNbr_Place() {
		return nbr_Place;
	}

	public void setNbr_Place(Long nbr_Place) {
		this.nbr_Place = nbr_Place;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}

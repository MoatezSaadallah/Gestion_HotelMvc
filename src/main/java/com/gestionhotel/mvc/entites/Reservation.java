package com.gestionhotel.mvc.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id_Reservation;
	private LocalDate date_Reservation;	
	@Temporal(TemporalType.DATE)
	private Date date_Arrive;
	@Temporal(TemporalType.DATE)
	private Date date_Depart;
	private int nbre_Personnes;
	private String commentaire;
	private String checkinout;
	@OneToOne(cascade = {CascadeType.ALL})
	private Client client;
	@OneToOne(cascade = {CascadeType.MERGE})
	private Chambre chambre;
	
	
	public Reservation() {
		super();
	}

	
	
	public Reservation(LocalDate date_Reservation, Date date_Arrive, Date date_Depart, int nbre_Personnes,
			String commentaire, Client client, Chambre chambre, String checkinout) {
		super();
		this.date_Reservation = date_Reservation;
		this.date_Arrive = date_Arrive;
		this.date_Depart = date_Depart;
		this.nbre_Personnes = nbre_Personnes;
		this.commentaire = commentaire;
		this.client = client;
		this.chambre = chambre;
		this.checkinout = checkinout;
	}






	public String getCheckinout() {
		return checkinout;
	}



	public void setCheckinout(String checkinout) {
		this.checkinout = checkinout;
	}



	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	public Long getId_Reservation() {
		return id_Reservation;
	}
	public void setId_Reservation(Long id_Reservation) {
		this.id_Reservation = id_Reservation;
	}
	public LocalDate getDate_Reservation() {
		return date_Reservation;
	}
	public void setDate_Reservation(LocalDate localDate) {
		this.date_Reservation = localDate;
	}
	public Date getDate_Arrive() {
		return date_Arrive;
	}
	public void setDate_Arrive(Date date_Arrive) {
		this.date_Arrive = date_Arrive;
	}
	public Date getDate_Depart() {
		return date_Depart;
	}
	public void setDate_Depart(Date date_Depart) {
		this.date_Depart = date_Depart;
	}
	public int getNbre_Personnes() {
		return nbre_Personnes;
	}
	public void setNbre_Personnes(int nbre_Personnes) {
		this.nbre_Personnes = nbre_Personnes;
	}
	
	
	

}

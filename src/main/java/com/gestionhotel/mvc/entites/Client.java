package com.gestionhotel.mvc.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id_Client;
	private String Nom;
	private String Prenom;
	private String Nationalite;
	private String type_Piece;
	private String num_Piece;
	private String Adresse;
	private String Telephone;
	@OneToOne(cascade = {CascadeType.ALL})
	private Reservation reservation;
	@OneToOne(cascade = {CascadeType.ALL})
	private Facture facture;
	
	
	public Client() {
		super();
	}
	
	
	
	
	public Client(String nom, String prenom, String nationalite, String type_Piece, String num_Piece, String adresse,
			String telephone, Reservation reservation, Facture facture) {
		super();
		Nom = nom;
		Prenom = prenom;
		Nationalite = nationalite;
		this.type_Piece = type_Piece;
		this.num_Piece = num_Piece;
		Adresse = adresse;
		Telephone = telephone;
		this.reservation = reservation;
		this.facture = facture;
	}




	public Reservation getReservation() {
		return reservation;
	}




	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}




	public Facture getFacture() {
		return facture;
	}




	public void setFacture(Facture facture) {
		this.facture = facture;
	}




	public Long getId_Client() {
		return id_Client;
	}
	public void setId_Client(Long id_Client) {
		this.id_Client = id_Client;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNationalite() {
		return Nationalite;
	}
	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}
	public String getType_Piece() {
		return type_Piece;
	}
	public void setType_Piece(String type_Piece) {
		this.type_Piece = type_Piece;
	}
	public String getNum_Piece() {
		return num_Piece;
	}
	public void setNum_Piece(String num_Piece) {
		this.num_Piece = num_Piece;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	
	
	
	
}

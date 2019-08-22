package com.gestionhotel.mvc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestionhotel.mvc.entites.Chambre;
import com.gestionhotel.mvc.entites.Client;
import com.gestionhotel.mvc.entites.Facture;
import com.gestionhotel.mvc.entites.Reservation;
import com.gestionhotel.mvc.entites.Tarif;
import com.gestionhotel.mvc.services.IChambreService;
import com.gestionhotel.mvc.services.IClientService;
import com.gestionhotel.mvc.services.IFactureService;
import com.gestionhotel.mvc.services.IReservationService;
import com.gestionhotel.mvc.services.ITarifService;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
	@Autowired
	private IClientService clientService;
	@Autowired
	private IChambreService chambreService;
	@Autowired
	private IReservationService reservationService;
	@Autowired
	private ITarifService tarifService;
	@Autowired
	private IFactureService factureService;

	@RequestMapping(value = "/")
	public String home() {

		return "home/home";
	}

	@RequestMapping(value = "/reserverchambre")
	public String reserverChambre(Model model) {
		List<Chambre> chambres = chambreService.selectAll();
		if (chambres == null) {
			chambres = new ArrayList<Chambre>();
		}
		model.addAttribute("chambres", chambres);

		Client client = new Client();
		model.addAttribute("client", client);
		return "reservation/reserverchambre";
	}

	@RequestMapping(value = "/reserverchambre/enregistrer", method = RequestMethod.GET)
	public String enregistrerClient(HttpServletRequest request, Model model, Client client) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();

		String date_Arrive = request.getParameter("date_Arrive");
		String date_Depart = request.getParameter("date_Depart");
		long num_Chambre = Integer.parseInt(request.getParameter("num_Chambre"));

		Chambre chambre = chambreService.getById(num_Chambre);
		Reservation reservation = new Reservation();
		Facture facture = new Facture();
		Tarif tarif = tarifService.getById((long) 1);
try {
	

		if (request.getParameter("petitdej") != null) {
			facture.setFPetitDej((long) 1);
		}	else {
			facture.setFPetitDej((long)0);
		}
		if (request.getParameter("litsupp") != null) {
			facture.setFLitSupp((long) 1);
		}else {
			facture.setFLitSupp((long)0);
		}
		if (request.getParameter("litbebe") != null) {
			facture.setFLitBebe((long) 1);
		}else {
			facture.setFLitBebe((long)0);
		}

		client.setNom(request.getParameter("nom"));
		client.setPrenom(request.getParameter("prenom"));
		client.setNationalite(request.getParameter("nationalite"));
		client.setAdresse(request.getParameter("adresse"));
		client.setType_Piece(request.getParameter("type_Piece"));
		client.setNum_Piece(request.getParameter("num_Piece"));
		client.setTelephone(request.getParameter("telephone"));


		reservation.setDate_Arrive(formatter.parse(date_Arrive));
		reservation.setDate_Depart(formatter.parse(date_Depart));
		reservation.setDate_Reservation(localDate);
		reservation.setNbre_Personnes(Integer.parseInt(request.getParameter("nbre_Personnes")));
		reservation.setClient(client);
		
		reservation.setChambre(chambre);
		reservation.setCommentaire(request.getParameter("commentaire"));
		reservation.setCheckinout(request.getParameter("0"));

		Date date1 = reservation.getDate_Arrive();
		Date date2 = reservation.getDate_Depart();

		double montant = (chambre.getTarif() * getDaysBetweenDates(date1, date2))
				+ (reservation.getNbre_Personnes() * tarif.getTaxeSejour() * getDaysBetweenDates(date1, date2)
						+ tarif.getLitBebe() * facture.getFLitBebe() * getDaysBetweenDates(date1, date2) * reservation.getNbre_Personnes()  + tarif.getLitSupp() * facture.getFLitSupp() * getDaysBetweenDates(date1, date2) * reservation.getNbre_Personnes()  
						+ tarif.getPetitDej() * facture.getFPetitDej() * getDaysBetweenDates(date1, date2) * reservation.getNbre_Personnes()   );

		facture.setMontant(montant);
		facture.setDate_Facture(date1);
		facture.setClient(client);

		client.setFacture(facture);

		chambre.setEtat("Reservé");
		chambre.setReservation(reservation);
		reservation.setClient(client);
		client.setReservation(reservation);

		if (chambre.getEtat() == "Reservé") {
			clientService.save(client);
			chambreService.update(chambre);
		} else {
			System.out.println("pas dispo");
		}
		
} catch (Exception e) {
	JFrame frame = new JFrame(); 

	JOptionPane.showMessageDialog(frame, "Veuillez remplir les champs vides");	
	}
		return "redirect:/reservation/reserverchambre/";
	}

	@RequestMapping(value = "/gererreservation")
	public String gererReservation(Model model) {
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);

		return "reservation/gererreservation";
	}

	@RequestMapping(value = "/gererreservation/modifier/{id_Client}")
	public String modifierReservation(Model model, @PathVariable Long id_Client) {

		if (id_Client != null) {
			Client client = clientService.getById(id_Client);
			if (client != null) {
				model.addAttribute("client", client);
			}
		}
		return "reservation/gererreservation";
	}

	@RequestMapping(value = "/gererreservation/enregistrer/{id_Client}", method = RequestMethod.GET)
	public String enregistrerModification(HttpServletRequest request, Model model, @PathVariable Long id_Client)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		Client client = clientService.getById(id_Client);
		String date_Arrive = request.getParameter("date_Arrive");
		String date_Depart = request.getParameter("date_Depart");
		long num_Chambre = Integer.parseInt(request.getParameter("num_Chambre"));

		Chambre chambre = chambreService.getById(num_Chambre);
		Reservation reservation = client.getReservation();
		Facture facture = client.getFacture();
		Tarif tarif = tarifService.getById((long) 1);

		client.setNom(request.getParameter("nom"));
		client.setPrenom(request.getParameter("prenom"));
		client.setNationalite(request.getParameter("nationalite"));
		client.setAdresse(request.getParameter("adresse"));
		client.setType_Piece(request.getParameter("type_Piece"));
		client.setNum_Piece(request.getParameter("num_Piece"));
		client.setTelephone(request.getParameter("telephone"));

		reservation.setDate_Arrive(formatter.parse(date_Arrive));
		reservation.setDate_Depart(formatter.parse(date_Depart));
		reservation.setDate_Reservation(localDate);
		reservation.setNbre_Personnes(Integer.parseInt(request.getParameter("nbre_Personnes")));
		reservation.setClient(client);
		reservation.setChambre(chambre);
		reservation.setCommentaire(request.getParameter("commentaire"));
		Date date1 = reservation.getDate_Arrive();
		Date date2 = reservation.getDate_Depart();
		double montant = (chambre.getTarif() * getDaysBetweenDates(date1, date2))
				+ (reservation.getNbre_Personnes() * tarif.getTaxeSejour() * getDaysBetweenDates(date1, date2));
		facture.setMontant(montant);
		facture.setDate_Facture(date1);
		facture.setClient(client);
		client.setFacture(facture);
		chambre.setEtat("Reservé");
		chambre.setReservation(reservation);
		reservation.setClient(client);
		client.setReservation(reservation);

		clientService.update(client);

		return "redirect:/reservation/gererreservation/";
	}

	@RequestMapping(value = "/gererreservation/supprimer/{id_Client}")
	public String supprimerReservation(Model model, @PathVariable Long id_Client) {
		try {
			if (id_Client != null) {
				Client client = clientService.getById(id_Client);
				Reservation reservation = client.getReservation();
				long idchambre = client.getReservation().getChambre().getId_Chambre();
				Chambre chambre = chambreService.getById(idchambre);
				Facture facture = client.getFacture();
				if (client != null) {
					clientService.remove(id_Client);
					reservationService.remove(reservation.getId_Reservation());
					factureService.remove(facture.getId_Facture());
					chambre.setEtat("Disponible");
					chambre.setReservation(null);
					chambreService.update(chambre);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/reservation/gererreservation/";
	}
	


	public static double getDaysBetweenDates(Date theEarlierDate, Date theLaterDate) {
		double result = Double.POSITIVE_INFINITY;
		if (theEarlierDate != null && theLaterDate != null) {
			final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
			Calendar aCal = Calendar.getInstance();
			aCal.setTime(theEarlierDate);
			long aFromOffset = aCal.get(Calendar.DST_OFFSET);
			aCal.setTime(theLaterDate);
			long aToOffset = aCal.get(Calendar.DST_OFFSET);
			long aDayDiffInMili = (theLaterDate.getTime() + aToOffset) - (theEarlierDate.getTime() + aFromOffset);
			result = ((double) aDayDiffInMili / MILLISECONDS_PER_DAY);
		}
		return result;
	}

}

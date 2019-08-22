package com.gestionhotel.mvc.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionhotel.mvc.entites.Chambre;
import com.gestionhotel.mvc.entites.Client;
import com.gestionhotel.mvc.entites.Reservation;
import com.gestionhotel.mvc.services.IChambreService;
import com.gestionhotel.mvc.services.IClientService;
import com.gestionhotel.mvc.services.IReservationService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	private IClientService clientService;
	@Autowired
	private IChambreService chambreService;
	@Autowired
	private IReservationService reservationService;


	
	@RequestMapping(value = "/")
	public String home(Model model) {
		List<Chambre> chambres = chambreService.selectAll();
		if (chambres == null) {
			chambres = new ArrayList<Chambre>();
		}
		model.addAttribute("chambres", chambres);

		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		

		model.addAttribute("clients", clients);
		
		
		

		return "home/home";
	}
	
	@RequestMapping(value = "/blank")
	public String blankHome() {
		
		return "blank/blank";
	}
	
	@RequestMapping(value = "/checkin/{id_Client}")
	public String checkIn(Model model, @PathVariable Long id_Client) {
			Client client = clientService.getById(id_Client);
			Reservation reservation = client.getReservation();
			reservation.setCheckinout("in");
			Chambre chambre = reservation.getChambre();
			chambre.setEtat("Occupé");

			clientService.update(client);

		return "redirect:/home/";
	}
	@RequestMapping(value = "/checkout/{id_Client}")
	public String checkOut(Model model, @PathVariable Long id_Client) {
			Client client = clientService.getById(id_Client);
			Reservation reservation = client.getReservation();
			reservation.setCheckinout("out");
			Chambre chambre = reservation.getChambre();
			chambre.setEtat("Disponible");
			chambre.setReservation(null);

			clientService.update(client);
		return "redirect:/home/";
	}

}

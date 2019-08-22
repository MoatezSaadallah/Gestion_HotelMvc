package com.gestionhotel.mvc.controllers;

import java.util.ArrayList;
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
import com.gestionhotel.mvc.services.IFactureService;
import com.gestionhotel.mvc.services.IReservationService;
import com.gestionhotel.mvc.services.ITarifService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
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

	
	@RequestMapping(value = "/info")
	public String home(Model model) {
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "client/info";
	}
	
	
	@RequestMapping(value = "/consulter/{id_Client}")
	public String consulterReservation(Model model, @PathVariable Long id_Client) {

		if (id_Client != null) {
			Client client = clientService.getById(id_Client);
			if (client != null) {
				model.addAttribute("client", client);
			}
		}
		return "client/info";
	}
	
	@RequestMapping(value = "/actualiser/{id_Client}")
	public String actualiserReservation(Model model, @PathVariable Long id_Client) {

		if (id_Client != null) {
			Client client = clientService.getById(id_Client);
			Reservation reservation = client.getReservation();
			Chambre chambre = reservation.getChambre();
			if (client != null) {
				chambre.setEtat("Reservé");
				chambre.setReservation(reservation);
				chambreService.update(chambre);
			}
		}
		return "redirect:/client/info";
	}

}

package com.gestionhotel.mvc.controllers;


import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
import com.gestionhotel.mvc.services.ITarifService;



@Controller
@RequestMapping(value = "/administration")
public class AdministrationController {
	
	@Autowired
	private IClientService clientService;
	@Autowired
	private IChambreService chambreService;
	@Autowired
	private ITarifService tarifService;

	@RequestMapping(value = "/")
	public String administration(Model model) {

		return "home/home";
	}

	@RequestMapping(value = "/ajouterchambre")
	public String ajouterChambre(Model model) {
		List<Chambre> chambres = chambreService.selectAll();
		if (chambres == null) {
			chambres = new ArrayList<Chambre>();
		}
		model.addAttribute("chambres", chambres);
		return "administration/ajouterchambre";
	}
	
	@RequestMapping(value = "/ajouterchambre/enregistrer", method = RequestMethod.GET)
	public String enregistrerChambre(HttpServletRequest request, Model model, Chambre chambre) {

		long nbr_place = Integer.parseInt(request.getParameter("nbr_Place"));
		long id_chambre = Integer.parseInt(request.getParameter("id_Chambre"));

		try {
			

		chambre.setId_Chambre(id_chambre);
		chambre.setNbr_Place(nbr_place);
		chambre.setEtat(request.getParameter("etat"));
		chambre.setType(request.getParameter("type"));
		chambre.setTarif(Double.parseDouble(request.getParameter("tarif")));
		chambreService.save(chambre);
		} catch (Exception e) {
			JFrame frame = new JFrame(); 

			JOptionPane.showMessageDialog(frame, "Attention , La chambre existe déja");
		}
		
		return "redirect:/administration/ajouterchambre/";
	}
	
	
	@RequestMapping(value = "/gererchambre")
	public String gererChambre(Model model) {
		List<Chambre> chambres = chambreService.selectAll();
		if (chambres == null) {
			chambres = new ArrayList<Chambre>();
		}
		model.addAttribute("chambres", chambres);
		return "administration/gererchambre";
	}
	
	
	@RequestMapping(value = "/gererchambre/supprimer/{id_Chambre}")
	public String supprimerChambre(Model model, @PathVariable Long id_Chambre) {
		if (id_Chambre != null) {
			Chambre chambre = chambreService.getById(id_Chambre);
			
			if (chambre != null) {
				chambreService.remove(id_Chambre);
		
			}
		}
		return "redirect:/administration/gererchambre/";
	}
	
	@RequestMapping(value = "/gererchambre/modifier/{id_Chambre}")
	public String modifierChambre(Model model, @PathVariable Long id_Chambre) {
		if (id_Chambre != null) {
			Chambre chambre = chambreService.getById(id_Chambre);
			if (chambre != null) {
				model.addAttribute("chambre", chambre);
			}
		}
		return "administration/gererchambre";
	}


	
	
	@RequestMapping(value = "/gererchambre/enregistrer/{id_Chambre}", method = RequestMethod.GET)
	public String enregistrerModification(HttpServletRequest request, Model model , @PathVariable Long id_Chambre)
			 {
		Chambre chambre = chambreService.getById(id_Chambre);
		long nbr_place = Integer.parseInt(request.getParameter("nbr_Place"));
		long id_chambre = Integer.parseInt(request.getParameter("id_Chambre"));
		
		chambre.setId_Chambre(id_chambre);
		chambre.setNbr_Place(nbr_place);
		chambre.setEtat(request.getParameter("etat"));
		chambre.setTarif(Double.valueOf(request.getParameter("tarif")));
		chambre.setType(request.getParameter("type"));
		

		
		chambreService.update(chambre);

		return "redirect:/administration/gererchambre/";
	}
	
	


	
	@RequestMapping(value = "/gerertarif")
	public String gerertarif(Model model) {
		List<Tarif> tarifs = tarifService.selectAll();
		if (tarifs == null) {
			tarifs = new ArrayList<Tarif>();
		}
		model.addAttribute("tarifs", tarifs);
		return "administration/gerertarif";
	}

	@RequestMapping(value = "/gerertarif/modifier/{id_Tarif}")
	public String modifierTarif(Model model, @PathVariable Long id_Tarif) {
		if (id_Tarif != null) {
			Tarif tarif = tarifService.getById(id_Tarif);
			if (tarif != null) {
				model.addAttribute("tarif", tarif);
			}
		}
		return "administration/gerertarif";
	}
	@RequestMapping(value = "/gerertarif/supprimer/{id_Tarif}")
	public String supprimerTarif(Model model, @PathVariable Long id_Tarif) {
		if (id_Tarif != null) {
			Tarif tarif = tarifService.getById(id_Tarif);
			
			if (tarif != null) {
				chambreService.remove(id_Tarif);
		
			}
		}
		return "redirect:/administration/gerertarif/";
	}
	@RequestMapping(value = "/gerertarif/enregistrer/{id_Tarif}", method = RequestMethod.GET)
	public String enregistrerModificationTarif(HttpServletRequest request, Model model , @PathVariable Long id_Tarif)
			 {
		Tarif tarif = tarifService.getById(id_Tarif);
		
		tarif.setId_Tarif(id_Tarif);
		tarif.setTaxeSejour(Double.valueOf(request.getParameter("taxesejour")));
		tarif.setPetitDej(Double.valueOf(request.getParameter("petitdej")));
		tarif.setLitSupp(Double.valueOf(request.getParameter("litsupp")));
		tarif.setLitBebe(Double.valueOf(request.getParameter("litbebe")));
	/*	tarif.setTaxeSejour(request.getParameter("libelle"));
		tarif.setPrix(Double.valueOf(request.getParameter("prix")));*/
		
		tarifService.update(tarif);

		return "redirect:/administration/gerertarif/";
	}
}

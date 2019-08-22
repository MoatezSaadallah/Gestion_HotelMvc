package com.gestionhotel.mvc.services;

import java.util.List;

import com.gestionhotel.mvc.entites.Facture;



public interface IFactureService {
	
	public Facture save(Facture entity);
	
	public Facture update(Facture entity);

	public List<Facture> selectAll();

	public List<Facture> selectAll(String sortField, String sort);

	public Facture getById(Long id);

	public void remove(Long id);

	public Facture findOne(String paramName, Object paramValue);

	public Facture findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}

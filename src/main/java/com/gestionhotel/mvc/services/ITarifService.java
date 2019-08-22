package com.gestionhotel.mvc.services;

import java.util.List;

import com.gestionhotel.mvc.entites.Tarif;



public interface ITarifService {
	
	public Tarif save(Tarif entity);
	
	public Tarif update(Tarif entity);

	public List<Tarif> selectAll();

	public List<Tarif> selectAll(String sortField, String sort);

	public Tarif getById(Long id);

	public void remove(Long id);

	public Tarif findOne(String paramName, Object paramValue);

	public Tarif findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}

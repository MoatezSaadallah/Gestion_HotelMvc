package com.gestionhotel.mvc.services;

import java.util.List;

import com.gestionhotel.mvc.entites.Chambre;



public interface IChambreService {
	
	public Chambre save(Chambre entity);
	
	public Chambre update(Chambre entity);

	public List<Chambre> selectAll();

	public List<Chambre> selectAll(String sortField, String sort);

	public Chambre getById(Long id);

	public void remove(Long id);

	public Chambre findOne(String paramName, Object paramValue);

	public Chambre findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}

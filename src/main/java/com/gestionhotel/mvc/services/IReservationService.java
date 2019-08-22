package com.gestionhotel.mvc.services;

import java.util.List;

import com.gestionhotel.mvc.entites.Reservation;



public interface IReservationService {
	
	public Reservation save(Reservation entity);
	
	public Reservation update(Reservation entity);

	public List<Reservation> selectAll();

	public List<Reservation> selectAll(String sortField, String sort);

	public Reservation getById(Long id);

	public void remove(Long id);

	public Reservation findOne(String paramName, Object paramValue);

	public Reservation findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}

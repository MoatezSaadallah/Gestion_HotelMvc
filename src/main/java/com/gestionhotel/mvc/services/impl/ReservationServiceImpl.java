package com.gestionhotel.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.mvc.dao.IReservationDao;
import com.gestionhotel.mvc.entites.Reservation;
import com.gestionhotel.mvc.services.IReservationService;



@Transactional
public class ReservationServiceImpl implements IReservationService {
	
	private IReservationDao dao;
	
	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public Reservation save(Reservation entity) {
		return dao.save(entity);
	}

	@Override
	public Reservation update(Reservation entity) {
		return dao.update(entity);
	}

	@Override
	public List<Reservation> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Reservation> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Reservation getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Reservation findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Reservation findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

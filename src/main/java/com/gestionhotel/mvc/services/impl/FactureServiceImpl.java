package com.gestionhotel.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.mvc.dao.IFactureDao;
import com.gestionhotel.mvc.entites.Facture;
import com.gestionhotel.mvc.services.IFactureService;



@Transactional
public class FactureServiceImpl implements IFactureService {
	
	private IFactureDao dao;
	
	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	@Override
	public Facture save(Facture entity) {
		return dao.save(entity);
	}

	@Override
	public Facture update(Facture entity) {
		return dao.update(entity);
	}

	@Override
	public List<Facture> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Facture> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Facture getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Facture findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Facture findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

package com.gestionhotel.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.mvc.dao.ITarifDao;
import com.gestionhotel.mvc.entites.Tarif;
import com.gestionhotel.mvc.services.ITarifService;



@Transactional
public class TarifServiceImpl implements ITarifService {
	
	private ITarifDao dao;
	
	public void setDao(ITarifDao dao) {
		this.dao = dao;
	}

	@Override
	public Tarif save(Tarif entity) {
		return dao.save(entity);
	}

	@Override
	public Tarif update(Tarif entity) {
		return dao.update(entity);
	}

	@Override
	public List<Tarif> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Tarif> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Tarif getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Tarif findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Tarif findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

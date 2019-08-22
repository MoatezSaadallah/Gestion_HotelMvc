package com.gestionhotel.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.mvc.dao.IChambreDao;
import com.gestionhotel.mvc.entites.Chambre;
import com.gestionhotel.mvc.services.IChambreService;



@Transactional
public class ChambreServiceImpl implements IChambreService {
	
	private IChambreDao dao;
	
	public void setDao(IChambreDao dao) {
		this.dao = dao;
	}

	@Override
	public Chambre save(Chambre entity) {
		return dao.save(entity);
	}

	@Override
	public Chambre update(Chambre entity) {
		return dao.update(entity);
	}

	@Override
	public List<Chambre> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Chambre> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Chambre getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Chambre findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Chambre findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

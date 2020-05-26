package com.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.dao.CategoriasDAO;
import com.capas.domain.Categorias;


@Service
public class CategoriasServiceImpl implements CategoriasService {
	
	@Autowired
	CategoriasDAO catDAO;

	@Override
	public List<Categorias> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return catDAO.findAll();
	}

	@Override
	public Categorias findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return catDAO.findOne(code);
	}

	@Override
	public void insert(Categorias cat) throws DataAccessException {
		catDAO.insertar(cat);
		
	}

}

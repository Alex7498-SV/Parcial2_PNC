package com.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.dao.LibroDAO;
import com.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findOne(code);
	}

	@Override
	public void save(Libro lib) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.save(lib);
	}

	@Override
	public void delete(Integer c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.delete(c_libro);
	}

}

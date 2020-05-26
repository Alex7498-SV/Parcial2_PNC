package com.capas.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.capas.domain.Libro;


public interface LibroDAO {

	public List<Libro> findAll() throws DataAccessException;
	public Libro findOne(Integer code) throws DataAccessException;
	public void insertar(Libro lib) throws DataAccessException;
	public void save(Libro lib) throws DataAccessException;
	public void delete(Integer code) throws DataAccessException;
	
}

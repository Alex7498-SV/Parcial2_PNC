package com.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.domain.Libro;

public interface LibroService {
	public List<Libro> findAll() throws DataAccessException;
	public Libro findOne(Integer code) throws DataAccessException;
	public void save(Libro lib) throws DataAccessException;
	public void delete(Integer c_libro) throws DataAccessException;
}

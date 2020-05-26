package com.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.domain.Libro;
import com.capas.domain.Categorias;

public interface CategoriasDAO {
	
	public void insertar(Categorias cat) throws DataAccessException;

	public Categorias findOne(Integer code) throws DataAccessException;
	
	public List<Categorias> findAll() throws DataAccessException;
	
}

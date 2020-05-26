package com.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.domain.Categorias;

public interface CategoriasService {
	public void insert(Categorias cat) throws DataAccessException;
	public List<Categorias> findAll() throws DataAccessException;
	public Categorias findOne(Integer code) throws DataAccessException;
}

package com.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.capas.domain.Libro;
import com.capas.domain.Categorias;

@Repository
public class CategoriasDAOImpl implements CategoriasDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Categorias> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categorias.class);
		List<Categorias> resulset = query.getResultList();
		return resulset;
		
	}

	@Override
	public Categorias findOne(Integer code) throws DataAccessException {
		Categorias cat = entityManager.find(Categorias.class, code);
		return cat;
	}

	@Override
	@Transactional
	public void insertar(Categorias cat) throws DataAccessException {
		entityManager.persist(cat);	
	}
	
}

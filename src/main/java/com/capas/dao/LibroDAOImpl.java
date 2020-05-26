package com.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.capas.domain.Libro;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class LibroDAOImpl implements LibroDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override		
	public List<Libro> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resulset = query.getResultList();
		return resulset;
		
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		Libro lib = entityManager.find(Libro.class, code);
		return lib;
	}

	@Override
	@Transactional
	public void insertar(Libro lib) throws DataAccessException {
		entityManager.persist(lib);	
	}
	
	@Override
	@Transactional
	public void save(Libro lib) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(lib.getC_libro() == null) {
				entityManager.persist(lib);
			}
			else {
				entityManager.merge(lib);
				entityManager.flush();
			}
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Libro contri = entityManager.find(Libro.class, code);
		entityManager.remove(contri);
		
	}
}

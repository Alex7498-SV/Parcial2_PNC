package com.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="cat_categoria")
public class Categorias {

	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_categoria;
	
	@Column(name="s_categoria")
	@Size(message = "El nombre no debe de tener mas de 15 caracteres",max=15)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String categoria;
	
	public Categorias() {
	}       

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}

package com.capas.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_libro;
	
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(referencedColumnName = "c_categoria", name = "c_categoria")
	private Categorias c_categorias;
	
	@Column(name="s_titulo")
	@Size(message = "El nombre no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String titulo;
	
	@Column(name="s_autor")
	@Size(message = "El apellido no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String autor;
	
	@Column(name="f_ingreso")
	private Date fecha;
	
	@Column(name="isbn")
	@Size(message = "El apellido no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String isbn;
	
	@Column(name="b_estado")
	private Boolean estado;

	public Libro() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(int c_libro) {
		this.c_libro = c_libro;
	}

	public Categorias getC_categorias() {
		return c_categorias;
	}

	public void setC_categorias(Categorias c_categorias) {
		this.c_categorias = c_categorias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(String.valueOf(fecha));
        String strDate = formatter.format(date2);
        return strDate;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstadoDelegate() {
        if(this.estado == null)return "";
        else {
            return estado == true ?"Activo":"Inactivo";
        }
	}
}

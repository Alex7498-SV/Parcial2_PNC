package com.capas.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import com.capas.dao.LibroDAO;
import com.capas.dao.CategoriasDAO;
import com.capas.domain.Libro;
import com.capas.domain.Categorias;

import com.capas.service.LibroService;
import com.capas.service.CategoriasServiceImpl;
import com.capas.service.CategoriasService;


@Controller
public class MainController {
	@Autowired
	private LibroService libroServ;
	@Autowired
	private CategoriasService catServ;
	
	@RequestMapping("/index")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "");
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping("/insertarLibro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		Libro lib = new Libro();
		Categorias cats = new Categorias();
		List<Categorias> categorias = null;
		
		try {
			categorias = catServ.findAll();
			mav.addObject("cats", categorias);
			mav.addObject("libro", lib);
			mav.setViewName("Ilibro");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping("/insertarCategoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		
		Categorias cat = new Categorias();
		mav.addObject("categoria", cat);
		mav.setViewName("Icategoria");
		
		return mav;
	}

	@RequestMapping("/guardarLibro")
	public ModelAndView guardar(@Valid @ModelAttribute Libro lib ,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Calendar c = Calendar.getInstance();
		String fecha = Integer.toString(c.get(Calendar.YEAR)) + "/" +
                Integer.toString(c.get(Calendar.MONTH)+1) + "/" +
                Integer.toString(c.get(Calendar.DATE)) + " " +
                Integer.toString(c.get(Calendar.HOUR_OF_DAY)) + ":" +
                Integer.toString(c.get(Calendar.MINUTE));
		Date date = new Date();
		
		if(!result.hasErrors()) {
			
			try {
				date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(fecha);
				
			} catch(ParseException ef) {
				ef.printStackTrace();
			}
			if(lib.getEstado()==null) {
                lib.setEstado(false);
            }
			
			lib.setFecha(date);
			libroServ.save(lib);
			mav.addObject("msg", "El libro se inserto con exito");
			mav.setViewName("index");
		}
		else {
			Categorias cats = new Categorias();
			List<Categorias> categorias = null;
			
			try {
				categorias = catServ.findAll();
				mav.addObject("cats", categorias);
				mav.addObject("libro", lib);
				mav.setViewName("Ilibro");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return mav;
		
	}
	
	
	@RequestMapping("/guardarCat")
	public ModelAndView guardarCat(@Valid @ModelAttribute Categorias cat ,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(!result.hasErrors()) {
			
			catServ.insert(cat);
			mav.addObject("msg", "La categoria se inserto con exito");
			mav.setViewName("index");
		}
		else {
			mav.addObject("categoria", cat);
			mav.setViewName("Icategoria");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView mostrar() {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("libros");
			List<Libro> libros = null;
			try {
				libros = libroServ.findAll();
				mav.addObject("libros", libros);
						 
			} catch(Exception e){
				e.printStackTrace();
			}
			
		return mav;
	}

}

package com.aguilarpgc.aulamatrix.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aguilarpgc.aulamatrix.logic.AlumnoLogic;
import com.aguilarpgc.aulamatrix.model.Curso;

@Controller
@RequestMapping(value = "admin/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoLogic alumnoLogic;
	
	@RequestMapping(value = "/cursos_matriculados", method = RequestMethod.GET)
	public String cursosMatriculados(ModelMap modelMap){
		
		System.out.println("aaa");
		for(Curso c : alumnoLogic.listCursosMatriculados()){
			System.out.println("!!! "+c.getNombre());
		}
		System.out.println("bbb");
		
		return "/curso/list";
	}
	
	
}

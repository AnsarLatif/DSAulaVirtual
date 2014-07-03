package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aguilarpgc.aulamatrix.logic.AlumnoLogic;
import com.aguilarpgc.aulamatrix.logic.DocumentoLogic;
import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.Documento;
import com.aguilarpgc.aulamatrix.model.Nota;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.util.Caster;
import com.aguilarpgc.aulamatrix.view.NotaBean;
import com.aguilarpgc.aulamatrix.view.TrabajoBean;

@Controller
@RequestMapping(value = "admin/alumno")
public class AlumnoController {

	@Autowired
	AlumnoLogic alumnoLogic;

	@Autowired
	DocumentoLogic documentoLogic;
	
	@RequestMapping(value = "/cursos_matriculados", method = RequestMethod.GET)
	public String cursosMatriculados(ModelMap modelMap){
		
		List<Curso> cursosList = alumnoLogic.listCursosMatriculados();
		for(Curso curso : cursosList){
			System.out.println("Curso: "+curso.getNombre());
		}
		modelMap.addAttribute("cursos", cursosList);
		
		return "/curso/list";
	}

	@RequestMapping(value = "/notas_trabajos", method = RequestMethod.GET)
	public String notasTrabajos(ModelMap modelMap){

		List<Nota> notas = alumnoLogic.listNotasTrabajo();
		List<NotaBean> notasBeans = new ArrayList<NotaBean>();
		for(Nota nota : notas){
			NotaBean notaBean = Caster.notaModelToBean(nota);
			Documento documento = documentoLogic.getDocumento(nota.getDocumento());
			
			notaBean.setNombreDocumento(documento.getNombre());
			notaBean.setNombreTrabajo(documentoLogic.getTrabajo(documento).getNombre());
			
			notasBeans.add(notaBean);
		}
		modelMap.addAttribute("notas", notasBeans);
		return "/curso/list";
	}
	
	@RequestMapping(value = "/trabajos_lista", method = RequestMethod.GET)
	public String trabajos(ModelMap modelMap){

		List<TrabajoBean> trabajosBeans = new ArrayList<TrabajoBean>();
		for(Trabajo trabajo : alumnoLogic.listTrabajos()){
			TrabajoBean trabajoBean = Caster.trabajoModelToBean(trabajo);
			trabajosBeans.add(trabajoBean);
		}
		
		modelMap.addAttribute("trabajos", trabajosBeans);
		return "/curso/list";
	}
	
}

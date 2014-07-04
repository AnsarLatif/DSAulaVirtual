package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aguilarpgc.aulamatrix.logic.AlumnoLogic;
import com.aguilarpgc.aulamatrix.logic.CursoLogic;
import com.aguilarpgc.aulamatrix.logic.DocumentoLogic;
import com.aguilarpgc.aulamatrix.logic.MatriculaLogic;
import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.Documento;
import com.aguilarpgc.aulamatrix.model.Grupo;
import com.aguilarpgc.aulamatrix.model.Matricula;
import com.aguilarpgc.aulamatrix.model.Modulo;
import com.aguilarpgc.aulamatrix.model.Nota;
import com.aguilarpgc.aulamatrix.model.Perfil;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.util.Caster;
import com.aguilarpgc.aulamatrix.view.CursoGrupoBean;
import com.aguilarpgc.aulamatrix.view.DetalleMatriculaBean;
import com.aguilarpgc.aulamatrix.view.MatriculaBean;
import com.aguilarpgc.aulamatrix.view.NotaBean;
import com.aguilarpgc.aulamatrix.view.TrabajoBean;

@Controller
@RequestMapping(value = "admin/alumno")
public class AlumnoController extends MasterController{

	@Autowired
	AlumnoLogic alumnoLogic;

	@Autowired
	DocumentoLogic documentoLogic;
	
	@Autowired
	CursoLogic cursoLogic;
	
	@Autowired
	MatriculaLogic matriculaLogic;
	
	@ModelAttribute("allCursos")
	public List<Curso> listCursos(){
		return cursoLogic.listCurso();
	}
	
	@ModelAttribute("allGrupos")
	public List<Grupo> listGrupos(){
		return new ArrayList<Grupo>();
	}
	
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
	
	@RequestMapping(value="/matricula",method=RequestMethod.GET)
	public String initFormMatricula(ModelMap modelMap){
		CursoGrupo cursoGrupo = new CursoGrupo();
		modelMap.addAttribute("cursoGrupo", cursoGrupo);
		return "/alumno/matricula";
	}
	
	@RequestMapping(value="/registro_matricula",method=RequestMethod.POST)
	public String agregarMatricula(final CursoGrupo cursoGrupo, final BindingResult bindingResult, final ModelMap modelMap){
		CursoGrupo cg = cursoLogic.getCursoGrupo(cursoGrupo.getIdGrupo(), cursoGrupo.getIdCurso());
		Matricula matricula = new Matricula();
		matricula.setIdUsuario("1"); //cambiar el usuario x defecto
		matricula.setIdCursoGrupo(cg.getId());
		matriculaLogic.addMatricula(matricula);
		
//		List<Matricula> matriculas = matriculaLogic.getMatriculaByAlumno("1"); //cambiar el usuario x defecto
//		List<CursoGrupoBean> cursosMatriculados = new ArrayList<CursoGrupoBean>();
//		for(Matricula matri : matriculas){
//			CursoGrupo cursogrupo = cursoLogic.getCursoGrupo(matri.getIdCursoGrupo());
//			Curso curso = cursoLogic.getCurso(cursogrupo.getIdCurso());
//			Grupo grupo = cursoLogic.getGrupo(cursogrupo.getIdGrupo());
//			
//			CursoGrupoBean bean = new CursoGrupoBean();
//			
//			bean.setCurso(curso.getNombre());
//			bean.setGrupo(grupo.getNombre());
//			
//			cursosMatriculados.add(bean);
//		}
//		
//		modelMap.addAttribute("cursos", cursosMatriculados);
//		
//		return "/alumno/consultar_curso";
		return initFormConsultarCurso(modelMap);
	}
	
	@RequestMapping(value="/grupos/{idCurso}",method=RequestMethod.GET)
	public @ResponseBody List listGrupos(@PathVariable String idCurso){
		List<Grupo> grupos = cursoLogic.getGrupoByCurso(Integer.parseInt(idCurso));
		return grupos;
	}
	
	@RequestMapping(value="/cargar_trabajo",method=RequestMethod.GET)
	public String initFormCargarTrabajo(ModelMap modelMap){
		return "/alumno/cargarTrabajo";
	}
	
	@RequestMapping(value="/consultar_curso",method=RequestMethod.GET)
	public String initFormConsultarCurso(ModelMap modelMap){
		List<Matricula> matriculas = matriculaLogic.getMatriculaByAlumno("1"); //cambiar el usuario x defecto
		List<CursoGrupoBean> cursosMatriculados = new ArrayList<CursoGrupoBean>();
		for(Matricula matri : matriculas){
			CursoGrupo cursogrupo = cursoLogic.getCursoGrupo(matri.getIdCursoGrupo());
			Curso curso = cursoLogic.getCurso(cursogrupo.getIdCurso());
			Grupo grupo = cursoLogic.getGrupo(cursogrupo.getIdGrupo());
			
			CursoGrupoBean bean = new CursoGrupoBean();
			
			bean.setCurso(curso.getNombre());
			bean.setGrupo(grupo.getNombre());
			
			cursosMatriculados.add(bean);
		}
		
		modelMap.addAttribute("cursos", cursosMatriculados);
		
		return "/alumno/consultar_curso";
	}
	
	@RequestMapping(value="/consultar_nota",method=RequestMethod.GET)
	public String initFormConsultarNota(ModelMap modelMap){
		return "/alumno/consultarNota";
	}
	
	@RequestMapping(value="/consultar_trabajo",method=RequestMethod.GET)
	public String initFormConsultarTrabajo(ModelMap modelMap){
		return "/alumno/consultarTrabjo";
	}
	
}

package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aguilarpgc.aulamatrix.logic.FormatoLogic;
import com.aguilarpgc.aulamatrix.logic.ProfesorLogic;
import com.aguilarpgc.aulamatrix.logic.TrabajoLogic;
import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupo;
import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.util.Caster;
import com.aguilarpgc.aulamatrix.view.TrabajoBean;


@Controller
@RequestMapping(value = "admin/profesor")
public class ProfesorController {

	@Autowired
	ProfesorLogic profesorLogic;
	
	@Autowired
	TrabajoLogic trabajoLogic;

	@Autowired
	FormatoLogic formatoLogic;
	
	@RequestMapping(value = "/cursos_asignados", method = RequestMethod.GET)
	public String listCursos (ModelMap modelMap){

        List<Curso> cursoList = profesorLogic.listCursos();
		/*List<CursoGrupoTipoBean> cursosBeans = new ArrayList<CursoGrupoTipoBean>();
		for(Curso curso : cursos) {
            if(curso!=null){
            	curso = cursoLogic.getCurso(curso.getId());
            	System.out.println("Hello "+curso.getId()+" "+curso.getNombre());
            	CursoBean bean = Caster.cursoModelToBean(curso);
            	//bean.setCustomer(Caster.customerModelToBean(manageCustomerLogic.getCustomer(bill.getIdCustomer())));

            	cursosBeans.add(bean);
            }
        }
		System.out.print("Go Map");
        modelMap.addAttribute("cursos", cursosBeans);*/
		System.out.print("Go View");
		return "/curso/list";
	}
	
	@RequestMapping(value = "/trabajos_lista", method = RequestMethod.GET)
	public String listTrabajos(ModelMap modelMap){
		
        List<Trabajo> trabajos = profesorLogic.listTrabajos();
		List<TrabajoBean> trabajosBeans = new ArrayList<TrabajoBean>();
		
		for(Trabajo trabajo : trabajos){
			TrabajoBean trabajoBean = new TrabajoBean();
			trabajoBean = Caster.trabajoModelToBean(trabajo);
			trabajosBeans.add(trabajoBean);
		}
		
		modelMap.addAttribute("trabajos", trabajosBeans);

		return "/curso/list";
	}
	
	
	@RequestMapping(value = "/subir_trabajo", method = RequestMethod.GET)
	public String moduloCargarTrabajo(ModelMap modelMap){

        List<Curso> cursoList = profesorLogic.listCursos();
        modelMap.addAttribute("cursos", cursoList);
        modelMap.addAttribute("trabajo", new TrabajoBean());
		return "/trabajo/formulario_trabajo";
	}
	
	@RequestMapping(value = "/subir_trabajo",params={"enviar"})
	public String cargarTrabajo(@RequestParam("trabajo") MultipartFile myFile, @Valid @ModelAttribute(value="trabajo") TrabajoBean trabajo,
			final BindingResult bindingResult, final ModelMap modelMap ){
		
		// No se lleno correctament el formulario
		if(bindingResult.hasErrors()){			
			//log.info("El total de errores es: " + bindingResult.getFieldErrorCount());
			for(FieldError error : bindingResult.getFieldErrors()) {
				//log.info("Campo: " + error.getField() + "Mensaje: " + error.getDefaultMessage());
			}
			return "/trabajo/formulario_trabajo";
		}	
		// El archivo no es consistente
		if(myFile.getSize() == 0){
			return "/trabajo/formulario_trabajo";
		}
		
		System.out.println("FILE: "+myFile.getContentType());
		
		if(!formatoLogic.isValid(myFile.getContentType()))
			return "/trabajo/formulario_trabajo";
		
		String ruta = trabajoLogic.saveFile(myFile);
		
		trabajo.setTipo(trabajo.getIntegrantesMaximo() == 1 ? "I" : "G");
		trabajo.setRuta(ruta);
		Trabajo trabajo1 = Caster.trabajoBeanToModel(trabajo);
		
		return "/curso/list";
	}
	
	@RequestMapping(value = "/subir_archivo", method = RequestMethod.POST)
	public String uploadTrabajo(@RequestParam("trabajo") MultipartFile myFile){

		System.out.println("FILE: "+myFile.getContentType());
		System.out.println("FILE: "+myFile.getName());
		System.out.println("FILE: "+myFile.getSize());
		System.out.println("FILE: "+myFile.getOriginalFilename());
		
		return "/curso/list";
	}
	
}

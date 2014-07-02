package com.aguilarpgc.aulamatrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aguilarpgc.aulamatrix.logic.CursoLogic;
import com.aguilarpgc.aulamatrix.logic.ProfesorLogic;
import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.CursoGrupoTipo;
import com.aguilarpgc.aulamatrix.util.Caster;
import com.aguilarpgc.aulamatrix.view.CursoBean;


@Controller
@RequestMapping(value = "admin/profesor")
public class ProfesorController {

	@Autowired
	ProfesorLogic profesorLogic;
	
	@RequestMapping(value = "/cursos_asisgnados", method = RequestMethod.GET)
	public String listCursos (ModelMap modelMap){

        List<CursoGrupoTipo> cursos = profesorLogic.listCurso();
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
	
}

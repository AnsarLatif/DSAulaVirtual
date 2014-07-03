package com.aguilarpgc.aulamatrix.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.aguilarpgc.aulamatrix.model.Bill;
import com.aguilarpgc.aulamatrix.model.BillDetail;
import com.aguilarpgc.aulamatrix.model.Currency;
import com.aguilarpgc.aulamatrix.model.Curso;
import com.aguilarpgc.aulamatrix.model.Customer;
import com.aguilarpgc.aulamatrix.model.Estado;
import com.aguilarpgc.aulamatrix.model.Nota;
import com.aguilarpgc.aulamatrix.model.Trabajo;
import com.aguilarpgc.aulamatrix.model.Usuario;
import com.aguilarpgc.aulamatrix.repository.BillRepository;
import com.aguilarpgc.aulamatrix.view.BillBean;
import com.aguilarpgc.aulamatrix.view.BillDetailBean;
import com.aguilarpgc.aulamatrix.view.CurrencyBean;
import com.aguilarpgc.aulamatrix.view.CursoBean;
import com.aguilarpgc.aulamatrix.view.CustomerBean;
import com.aguilarpgc.aulamatrix.view.EstadoBean;
import com.aguilarpgc.aulamatrix.view.NotaBean;
import com.aguilarpgc.aulamatrix.view.TrabajoBean;
import com.aguilarpgc.aulamatrix.view.UsuarioBean;

public class Caster {
	
	private final static Logger log = Logger.getLogger(Caster.class);

	public static CustomerBean customerModelToBean(Customer model,CustomerBean bean){
		log.info("* Convertir Customer Modelo -> Bean [Inicio] *");
		if(bean!=null){   
			bean.setId(model.getId());
			bean.setName(model.getName());
			bean.setRuc(model.getName());
			bean.setAddress(model.getAddress());
		}
		log.info("* Convertir Customer Modelo -> Bean [Fin] *");
		return bean;
	}
	
	public static Customer customerBeanToModel(CustomerBean bean, Customer model){
		log.info("* Convertir Customer Bean -> Modelo [Inicio] *");
		if(model!=null){
			model.setId(bean.getId());
			model.setName(bean.getName());
			model.setRuc(bean.getRuc());
			model.setAddress(bean.getAddress());
		}
		log.info("* Convertir Customer Bean -> Modelo [Inicio] *");
		return model;
	}
	
	public static Customer customerBeanToModel(CustomerBean bean){
		log.info("* Convertir Customer Bean -> Modelo nuevo [Inicio] *");
		Customer model = new Customer();
		model.setName(bean.getName());
		model.setRuc(bean.getRuc());
		model.setAddress(bean.getAddress());
		log.info("* Convertir Customer Bean -> Modelo nuevo [Fin] *");
		return model;
	}
	
	public static CustomerBean customerModelToBean(Customer customer){
		log.info("* Convertir Customer Modelo -> Bean nuevo [Inicio] *");
		CustomerBean bean = new CustomerBean();
		bean.setId(customer.getId());
		bean.setName(customer.getName());
		bean.setRuc(customer.getRuc());
		bean.setAddress(customer.getAddress());
		log.info("* Convertir Customer Modelo -> Bean nuevo [Fin] *");
		return bean;
	}
	
	public static BillDetail billDetailBeanToModel(BillDetailBean bean){
		log.info("* Convertir BillDetail Bean -> Modelo [Inicio] *");
		BillDetail model = new BillDetail();
		if(bean.getId() != null)
			model.setId(bean.getId());	
		model.setNumber(bean.getNumber());
		model.setQuantity(bean.getQuantity());
		model.setUnitPrice(bean.getUnitPrice());
		model.setAmount(bean.getAmount());
		model.setDescription(bean.getDescription());
		log.info("* Convertir BillDetail Bean -> Modelo [Fin] *");
		return model;
	}
	
	
	
	public static BillDetailBean billDetailModelToBean(BillDetail model){
		log.info("* Convertir BillDetail Modelo -> Bean [Inicio] *");
		BillDetailBean bean = new BillDetailBean();
		bean.setId(model.getId());
		bean.setAmount(model.getAmount());
		bean.setDescription(model.getDescription());
		bean.setIdBill(model.getBill().getId());
		bean.setNumber(model.getNumber());
		bean.setQuantity(model.getQuantity());
		bean.setUnitPrice(model.getUnitPrice());
		log.info("* Convertir BillDetail Modelo -> Bean [Fin] *");
		return bean;
	}
	
	public static CurrencyBean currencyModelToBean(Currency model){
		log.info("* Convertir Currency Modelo -> Bean [Inicio] *");
		CurrencyBean bean = new CurrencyBean();
		bean.setId(model.getId());
		bean.setCountry(model.getCountry());
		bean.setDenomination(model.getDenomination());
		bean.setSymbol(model.getSymbol());
		log.info("* Convertir Currency Modelo -> Bean [Fin] *");
		return bean;
	}
	
	public static Bill billBeanToModel(BillBean bean){
		log.info("* Convertir Bill Bean -> Modelo [Inicio] *");
		Bill bill = new Bill();
		if(bean.getId() != null)
			bill.setId(bean.getId());		
		bill.setReferralGuide(bean.getReferralGuide());
		bill.setConditions(bean.getConditions());
		bill.setExchangeRate(bean.getExchangeRate());
		bill.setSon(bean.getSon());
//		bill.setIssueDate(bean.getIssueDate());
		bill.setIdCurrency(bean.getIdCurrency());
		bill.setSubtotal(bean.getSubtotal());
		bill.setIgv(bean.getIgv());
		bill.setTotal(bean.getTotal());
		bill.setIdCustomer(bean.getIdCustomer());
		bill.setNumber(bean.getNumber());
		log.info("* Convertir Bill Bean -> Modelo [Fin] *");
		return bill;
	}
	
	public static BillBean billModelToBean(Bill model){
		log.info("* Convertir Bill Modelo -> Bean [Inicio] *");
		BillBean bill = new BillBean();
		bill.setId(model.getId());
		bill.setConditions(model.getConditions());
		bill.setExchangeRate(model.getExchangeRate());
		bill.setIdCurrency(model.getIdCurrency());
		bill.setIdCustomer(model.getIdCustomer());
		bill.setIgv(model.getIgv());
		bill.setIssueDate(model.getIssueDate());
		bill.setNumber(model.getNumber());
		bill.setReferralGuide(model.getReferralGuide());
		bill.setSon(model.getSon());
		bill.setSubtotal(model.getSubtotal());
		bill.setTotal(model.getTotal());
		List<BillDetailBean> list = new ArrayList<BillDetailBean>();
		
		for(BillDetail detail: model.getDetails()){
			log.debug("* Detalle : "+detail.getNumber()+" "+detail.getDescription()+" "+detail.getAmount());
			list.add(Caster.billDetailModelToBean(detail));
		}
		
		bill.setDetails(list);
		log.info("* Convertir Bill Modelo -> Bean [Fin] *");
		return bill;
	}
	
	
	/* AULA MATRIX
	 * 
	 */
	
	public static UsuarioBean usuarioModelToBean(Usuario model){
		System.out.println("1111 usuario :"+model.getId() + " "+model.getNombre());
		UsuarioBean usuario = new UsuarioBean();
		usuario.setId(model.getId());
		usuario.setUsuario(model.getUsuario());
		usuario.setNombre(model.getNombre());
		usuario.setApPaterno(model.getApellidoPaterno());
		usuario.setApMaterno(model.getApellidoMaterno());
		usuario.setEstado(model.getEstado().getDescripcion());
		usuario.setPerfil(model.getPerfil().getDescripcion());
		return usuario;
	}
	
	public static CursoBean cursoModelToBean(Curso model){
		System.out.println("1111 curso :"+model.getId() + " "+model.getNombre());
		CursoBean curso = new CursoBean();
		curso.setId(model.getId());
		curso.setNombre(model.getNombre());
		System.out.println("2222 curso :"+curso.getId() + " "+curso.getNombre());
		return curso;
	}
	

	public static EstadoBean estadoModelToBean(Estado model){
		System.out.println("1111 estado :"+model.getId() + " "+model.getDescripcion());
		EstadoBean estado = new EstadoBean();
		estado.setId(model.getId());
		estado.setDescripcion(model.getDescripcion());
		System.out.println("2222 estado :"+estado.getId() + " "+estado.getDescripcion());
		return estado;
	}
	
	public static NotaBean notaModelToBean(Nota model){
		System.out.println("1111 nota :"+model.getId() + " "+model.getDocumento());
		NotaBean nota = new NotaBean();
		nota.setId(model.getId());
		nota.setNota(model.getNota());
		System.out.println("2222 nota :"+nota.getId() + " "+nota.getDocumento());
		return nota;
	}
	
	public static TrabajoBean trabajoModelToBean(Trabajo model){
		System.out.println("1111 trabajo :"+model.getId() + " "+model.getNombre());
		TrabajoBean trabajo = new TrabajoBean();
		trabajo.setId(model.getId());
		try {
			trabajo.setFechaMax(Formatter.stringToDate(model.getFechaMaxima()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		trabajo.setNombre(model.getNombre());
		trabajo.setIntegrantesMax(model.getIntegrantesMaximo());
		trabajo.setRuta(model.getRuta());
		trabajo.setTipo(model.getTipo());
		trabajo.setCursoGrupoTipoId(model.getIdCursoGrupoTipo());

		System.out.println("2222 trabajo :"+trabajo.getId() + " "+ trabajo.getNombre());
		return trabajo;
	}
	
	
}

package com.aguilarpgc.aulamatrix.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aguilarpgc.aulamatrix.model.Currency;

@Repository
@Transactional
public class CurrencyRepository extends HibernateRepository{

	public List<Currency> listCurrency(){
		Criteria criteria = getSession().createCriteria(Currency.class);
		return criteria.list();
	}
	
	public Currency getCurrency(Integer idCurrency){
		return (Currency) getSession().get(Currency.class, idCurrency);
	}
	
}

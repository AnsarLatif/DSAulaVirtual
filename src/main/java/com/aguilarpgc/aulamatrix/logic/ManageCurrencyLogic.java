package com.aguilarpgc.aulamatrix.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguilarpgc.aulamatrix.model.Currency;
import com.aguilarpgc.aulamatrix.repository.CurrencyRepository;

@Service
public class ManageCurrencyLogic {

	@Autowired
	private CurrencyRepository currencyRepostory;
	
	public List<Currency> listCurrency(){
		return currencyRepostory.listCurrency();
	}
	
	public Currency getCurrency(Integer id){
		return currencyRepostory.getCurrency(id);
	}
	
}

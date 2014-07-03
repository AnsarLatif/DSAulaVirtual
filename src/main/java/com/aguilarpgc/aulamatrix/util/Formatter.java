package com.aguilarpgc.aulamatrix.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

	public static String amount(double amount){
		String newAmount = "";
		NumberFormat formatter = new DecimalFormat("#0.00");
		newAmount = formatter.format(amount).replace(',', '.');
		return newAmount;
	}
	
	public static String dateToString(Date date){
		
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	public static Date stringToDate(String string) throws ParseException{

		return new SimpleDateFormat("yyyyMMdd").parse(string);
	}
}

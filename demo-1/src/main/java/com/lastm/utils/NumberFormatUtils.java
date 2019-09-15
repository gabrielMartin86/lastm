package com.lastm.utils;

public interface NumberFormatUtils {
	
	static Double round05(Double db){
		String number = String.valueOf(db);
		String decimals = number.substring(number.indexOf("."));
		if(decimals != null && decimals.equals(".0"))
			return new Double(0);
		
		int numberD =  db.intValue();
		double dd = new Double("0"+decimals);
		float ff =  ((float)Math.ceil(dd/new Float("0.05"))) * new Float("0.05");
		double decimalDouble =  (double) (Math.round(new Double("0"+decimals) *20.0)/20.0);
		return new Double(numberD) + decimalDouble;
	}

}

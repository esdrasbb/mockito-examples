package org.uni7.pos.util;

import java.util.List;

public class ReturnValuesExample {

	private boolean booleano;
	
	private int inteiro;
	
	private long inteiroLongo;
	
	private double decimal;

	private Boolean booleanoWrapper;
	
	private Integer inteiroWrapper;
	
	private Long inteiroLongoWrapper;
	
	private Double decimalWrapper;
	
	private SimpleBusinessService businessService;
	
	
	public SimpleBusinessService getBusinessService() {
		return businessService;
	}
	

	public boolean isBooleano() {
		return booleano;
	}

	public Boolean getBooleanoWrapper() {
		return booleanoWrapper;
	}

	public int getInteiro() {
		return inteiro;
	}

	public long getInteiroLongo() {
		return inteiroLongo;
	}

	public double getDecimal() {
		return decimal;
	}

	public Integer getInteiroWrapper() {
		return inteiroWrapper;
	}

	public Long getInteiroLongoWrapper() {
		return inteiroLongoWrapper;
	}

	public Double getDecimalWrapper() {
		return decimalWrapper;
	}
	
	public List<Integer> getLista(){
		return null;
	}

}

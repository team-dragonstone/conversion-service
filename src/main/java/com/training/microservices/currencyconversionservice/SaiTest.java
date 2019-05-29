package com.training.microservices.currencyconversionservice;

public class SaiTest {
	
	public String stringTest() {
		String badPracticeString = new String();
		String goodPracticeString = "";
		
		badPracticeString = "testing";
		goodPracticeString = badPracticeString;
		
		return goodPracticeString;
	}
	
	public String badPracticeString() {
		
		String badPracticeString = "";
		for(int i=1; i<=20; i++) {
			badPracticeString += Integer.toString(i);
		}
		
		return badPracticeString;
	}
	
	public String goodPracticeString() {
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=20; i++) {
			sb.append(i);
		}
		
		return sb.toString();
	}
	
	public int addition(int x, int y) {
		return x + y;
	}
	
}

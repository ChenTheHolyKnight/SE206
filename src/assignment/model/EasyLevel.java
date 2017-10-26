package assignment.model;

import java.util.Random;

public class EasyLevel implements Level{
	
	private Levels _levelStr=Levels.EASY;

	/**
	 * This is to generate a number from 1 to 10
	 */
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(9)+1;
	}

	/**
	 * This is to get the field value that indicates what level this level is in
	 */
	@Override
	public Levels getLevels() {		
		return _levelStr;
	}

	/**
	 * This is to generate a formula and combine them into a string
	 * */
	@Override
	public String generateFormula(){
		int num1=generateNumber();
		String num1Str=Integer.toString(num1);
		String sign=new Arithmatic().getExpression(2);
		int num2=generateNumber();
		String num2Str=Integer.toString(num2);
		String formula=num1Str+sign+num2Str;
		return formula;
	}



}

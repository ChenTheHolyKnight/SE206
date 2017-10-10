package assignment.model;

import java.util.Random;

public class EasyLevel implements Level{
	
	private Levels _levelStr=Levels.EASY;

	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(9)+1;
	}

	@Override
	public Levels getLevels() {		
		return _levelStr;
	}
	
	@Override
	public String generateFormula(){
		int num1=generateNumber();
		String num1Str=Integer.toString(num1);
		String sign=new Arithmatic().getEasyExpression();
		int num2=generateNumber();
		String num2Str=Integer.toString(num2);
		String formula=num1Str+sign+num2Str;
		return formula;
	}



}

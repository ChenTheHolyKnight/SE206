package assignment.model;

import java.util.Random;


public class HardLevel implements Level{

	private Levels _levelStrs=Levels.HARD;
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(99)+1;
	}

	@Override
	public Levels getLevels() {
		return _levelStrs;
	}

	@Override
	public String generateFormula() {
		int num1=generateNumber();
		String num1Str=Integer.toString(num1);
		String sign=new Arithmatic().getHardExpression();
		int num2=generateNumber();
		String num2Str=Integer.toString(num2);
		String formula=num1Str+sign+num2Str;
		return formula;
	}



}

package assignment.model;

import java.util.Random;


public class HardLevel implements Level{

	private Levels _levelStrs=Levels.HARD;

	/**
	 * This is to generate a random number from 1 to 99*/
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(99)+1;
		//return rand.nextInt(40)+1;
	}

	/**
	 * This is to get the field that indicates the level
	 */
	@Override
	public Levels getLevels() {
		return _levelStrs;
	}

	/**
	 * This is to generate a formula in hard level
	 */
	@Override
	public String generateFormula() {
		int num1=generateNumber();
		String num1Str=Integer.toString(num1);
		String sign1=new Arithmatic().getHardExpression();
		int num2=generateNumber();
		String num2Str=Integer.toString(num2);
		String sign2=new Arithmatic().getHardExpression();
		int num3=generateNumber();
		String num3Str=Integer.toString(num3);
		String sign3=new Arithmatic().getHardExpression();
		int num4=generateNumber();
		String num4Str=Integer.toString(num4);
		String formula=num1Str+sign1+num2Str+sign2+num3Str+sign3+num4;
		return formula;
	}



}

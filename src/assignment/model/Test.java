package assignment.model;


public class Test {
	public static void main(String[] args) {
		Arithmatic arith=new Arithmatic();/*
		for(int i=0;i<10;i++) {
			String s=arith.getEasyExpression();
			System.out.println(s);
		}*/
		//boolean bool=arith.isOutOfBound("99-1");
		//System.out.println(bool);
		EasyLevel level=new EasyLevel();
		String s=level.generateFormula();
		//System.out.println(s);
		int num=arith.formulaToNumber(s);
		
		System.out.println(num);
	}

}


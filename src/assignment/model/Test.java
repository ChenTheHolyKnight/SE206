package assignment.model;


public class Test {
	public static void main(String[] args) {
		Arithmatic arith=new Arithmatic();
		
		boolean s=arith.isOutOfBound(" 2 + 5 + 3 / 1");
		System.out.println(arith.formulaToNumber(" 2 x 5 x 3 x  1"));
		System.out.println(s);	
	}

}


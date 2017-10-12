package assignment.model;


public class Test {
	public static void main(String[] args) {
		String s=" ";
		boolean b=s.matches("[*+-/()0-9x\\s]")&&!s.matches("[.,]");
		System.out.println(b);
	}

}


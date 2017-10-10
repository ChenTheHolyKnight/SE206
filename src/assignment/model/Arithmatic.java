package assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arithmatic {
	private List<String> _list=new ArrayList<String>();
	public Arithmatic(){
		_list.add("+");
		_list.add("-");
		_list.add("*");
	}
	
	public String getMuitiplication() {
		return _list.get(3);
	}
	
	public String getEasyExpression() {
		Random rand =new Random();
		int index=rand.nextInt(2);
		return _list.get(index);
	}
	
	public String getHardExpression() {
		Random rand =new Random();
		int index=rand.nextInt(1);
		return _list.get(index);
	}
}

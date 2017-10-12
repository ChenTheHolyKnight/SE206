package assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Arithmatic {
	private List<String> _list=new ArrayList<String>();
	public Arithmatic(){
		_list.add("+");
		_list.add("-");
		_list.add("*");
	}
	
	/*public String getMuitiplication() {
		return _list.get(2);
	}*/
	
	public String getEasyExpression() {
		Random rand =new Random();
		int index=rand.nextInt(2);
		return _list.get(index);
	}
	
	public String getHardExpression() {
		Random rand =new Random();
		int index=rand.nextInt(3);
		return _list.get(index);
	}
	
	public boolean isOutOfBound(String formula) {		
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("js");
		try {
			int result=(int)engine.eval(formula);
			if(result>0&&result<=99) {
				return false;
			}			
		} catch (Exception e) {
			return true;			
		}
		return true;		
	}
	
	public int formulaToNumber(String formula) {
		
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("js");
		try {
			formula=formula.replaceAll("x", "*");
			
			int result=(int)engine.eval(formula);
			return result;
		} catch (Exception e) {
			//e.printStackTrace();
			return -1;
		}		
		
	}
	
}

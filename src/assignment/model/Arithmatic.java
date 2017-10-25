package assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Arithmatic {
	private List<String> _list=new ArrayList<String>();

	/**add the operands in the list. Considering the level of math for 8-10 years old child, we think division is too hard
	 * for them to solve.So we decide not putting division operand in the game(even the hard level) but we alllow their parent
	 * to put them in the game if it is necessary
	 * */
	public Arithmatic(){
		_list.add("+");
		_list.add("-");
		_list.add("*");
	}
	


	public String getExpression(Level.Levels levels) {
		int num=0;
		if(levels.equals(Level.Levels.EASY)){
			num=2;
		}else{
			num=3;
		}
		Random rand =new Random();
		int index=rand.nextInt(num);
		return _list.get(index);
	}

	/**
	 * This is to detect whether the formula generated is out of the bound from 1-99
	 */
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

	/**
	 * This is to get the answer of the formula. ie 4 will be output if the input formula is 2+2
	 */
	public int formulaToNumber(String formula) {
		
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("js");
		try {
			formula=formula.replaceAll("x", "*");
			int result=(int)engine.eval(formula);
			return result;
		} catch (Exception e) {
			return -1;
		}		
		
	}
	
}

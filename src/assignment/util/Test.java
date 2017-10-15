package assignment.util;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	public static void main(String[] args) {
		/*ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("js");
		try {
			Object result=engine.eval("58-65");
			System.out.println(result);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		Answer answer=new Answer();
		answer.checkAnswer(10);
		Boolean bool=answer.isGrammarCorrect(10);
		System.out.println(bool);
		
		
	}

}


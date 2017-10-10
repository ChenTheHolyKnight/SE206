package assignment.model;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	public static void main(String[] args) {
		Arithmatic arith=new Arithmatic();
		String s=arith.getEasyExpression();
		System.out.println(s);
	}

}


package assignment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

		/*
		Answer answer=new Answer();
		answer.checkAnswer(10);
		Boolean bool=answer.isGrammarCorrect(10);
		System.out.println(bool);
		*/

		/*
		SimpleDateFormat myFormat = new SimpleDateFormat("mm ss SS");
		String inputString1 = "23 01 10";
		String inputString2 = "27 04 10";

		try {
			Date date1 = myFormat.parse(inputString1);
			Date date2 = myFormat.parse(inputString2);
			long diff = date2.getTime() - date1.getTime();
			System.out.println(diff);
			long millis=TimeUnit.MILLISECONDS.convert(diff, TimeUnit.MILLISECONDS);
			Date time=new Date(millis);
			System.out.println(time.toString());
			//System.out.println ("MILLLI: " + TimeUnit.MILLISECONDS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/

		Date date1=new Date();
		try {
			Thread.sleep(8000);
		}catch(Exception e){
			System.out.println("error");
		}

		Date date2=new Date();
		SimpleDateFormat myFormat = new SimpleDateFormat("mm ss SS");


		//long diff = date2.getTime() - date1.getTime();
		long sec=date2.getSeconds()-date1.getSeconds();
		long milli=date2.getMinutes()-date1.getMinutes();
		System.out.println(sec);

		//Date time=new Date(millis);
		//System.out.println(time.toString());
		//System.out.println ("MILLLI: " + TimeUnit.MILLISECONDS.convert(diff, TimeUnit.MILLISECONDS));


	}

}


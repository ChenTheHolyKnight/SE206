package assignment.util;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		//Recorder recorder=new Recorder("foo");
		//recorder.record();
		//recorder.recordToWord();
	/*
		Answer answer =new Answer();
		answer.Display();
		boolean correct=answer.checkAnswer(10);
		System.out.println(correct);
		*/
		
		FileReader reader=new FileReader() ;
		//reader.readFile();
		//reader.trimFile();
		//reader.display();
		//System.out.println(reader.getRecordFile());
		Answer answer = new Answer();
		boolean b=answer.checkAnswer(52);
		//System.out.println(b);
		String s=answer.getPLayerAnswer();
		System.out.println(s);
	}

}


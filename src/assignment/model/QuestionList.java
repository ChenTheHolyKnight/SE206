package assignment.model;

import java.util.ArrayList;

public class QuestionList {
	private static ArrayList<String> _list=new ArrayList<String>();
	
	private QuestionList() {
		
	}
	
	public static ArrayList<String> getInstance(){
		return _list;
	}
}

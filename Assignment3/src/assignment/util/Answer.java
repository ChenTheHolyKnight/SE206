package assignment.util;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	private List<String> _answerList=new ArrayList<String>();
	public Answer() {
		loadAnswerList();
	}
	
	public boolean checkAnswer(int num) {
		//the 1 in the equals bracket should be changed later.
		//System.out.println(_answerList.get(num-1));
		if(num<10) {
			return _answerList.get(num-1).equals("tekau");
		}else {
			int tenth=num/10;
			int oneth=num%10;
			//further implementation needs to be done
		}
		return _answerList.get(num-1).equals("iwa");//needs to be deleted
	}
	
	public void Display() {
		System.out.println(_answerList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void loadAnswerList() {
		_answerList.add("tahi");
		_answerList.add("rua");
		_answerList.add("toru");
		_answerList.add("whaa");
		_answerList.add("rima");
		_answerList.add("ono");
		_answerList.add("whitu");
		_answerList.add("waru");
		_answerList.add("iwa");
		_answerList.add("tekau");
	}
	
	
	
	
	
	
}

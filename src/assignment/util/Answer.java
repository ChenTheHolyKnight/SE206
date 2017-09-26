package assignment.util;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	private List<String> _answerList=new ArrayList<String>();
	private List<String> _answer;
	private List<String> _list;

	public Answer() {
		_answer=new ArrayList<String>();
		loadAnswerList();
	}

	public boolean checkAnswer(int num) {

		FileReader reader=new FileReader();
		_list=reader.getRecordFile();
		if(_list==null) {
			return false;
		}else if(_list.size()==0) {
			return false;
		}


		if(num<10) {
			_answer.add(_answerList.get(num-1));
			return _answer.equals(_list);
		}else {
			int tenth=num/10;
			int oneth=num%10;
			if(tenth==1) {
			}else {
				_answer.add(_answerList.get(tenth-1));
			}
			_answer.add("tekau");
			if(oneth!=0) {
				_answer.add("maa");
				_answer.add(_answerList.get(oneth-1));
			}
			return _answer.equals(_list);
		}
	}

	public String getAnswer(){
		String answer=String.join(" ", _answer);
		return answer;
	}

	public String getPLayerAnswer(){
			String list=String.join(" ", _list);
			return list;
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

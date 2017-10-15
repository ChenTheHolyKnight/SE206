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
		buildAnswer(num);

		if(_list==null) {
			return false;
		}else if(_list.size()==0) {
			return false;
		}

		/*
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
		}*/
		return _answer.equals(_list);
	}

	private void buildAnswer(int num){

		if(num<10) {
			_answer.add(_answerList.get(num-1));
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


	public boolean isGrammarCorrect(int num){
		int answerLength=_list.size();
		if(answerLength>4){
			return false;
		}
		if(answerLength==1){
			String first=_list.get(0);
			boolean isValid=isInTheAnswerList(first);
			return isValid;
		}

		if(answerLength==2){
			String first=_list.get(0);
			boolean isValid=isInTheAnswerList(first);
			String second=_list.get(1);
			if(isValid&&second.equals("tekau")){
				return true;
			}else{
				return false;
			}
		}

		if(answerLength==3){
			String first=_list.get(0);
			String second=_list.get(1);
			String third=_list.get(2);
			boolean isValid=isInTheAnswerList(third);
			if(isValid&&first.equals("tekau")&&second.equals("maa")){
				return true;
			}else{
				return false;
			}
		}

		if(answerLength==4){
			String first=_list.get(0);
			boolean isValid=isInTheAnswerList(first);
			String second=_list.get(1);
			String third=_list.get(2);
			String fourth=_list.get(3);
			boolean isValid2=isInTheAnswerList(fourth);
			if(isValid&&second.equals("tekau")&&third.equals("maa")&&isValid2){
				return true;
			}else{
				return false;
			}
		}




		return false;
	}




	private boolean isInTheAnswerList(String s){
		for(String s1:_answerList){
			if(s1.equals(s)){
				return true;
			}
		}
		return false;
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

package assignment.model;


import assignment.util.InterfaceAdapter;
import assignment.util.JsonFileIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class Test {
	public static void main(String[] args) {
		/*
		ArrayList<String> _list=new ArrayList<>();
		_list.add("1");
		JsonFileIO jf=new JsonFileIO();
		jf.writeFile("Question.json",_list);
		*/
		/*
		Time time=new Time();
		time.start();
		String s=time.getStart();
		System.out.println(s);
		*/
		Level level=new HardLevel();
		String s=level.generateFormula();
		System.out.println(s);
	}

}


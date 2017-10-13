package assignment.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class Test {
	public static void main(String[] args) {
		/*String s=" ";
		boolean b=s.matches("[*+-/()0-9x\\s]")&&!s.matches("[.,]");
		System.out.println(b);*/

		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
				.create();
		try{
			BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+"First.json"));
			Player player=gson.fromJson(br,Player.class);
			System.out.println(player.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		Player player=new Player();
		player.setName("player1");
		JsonFileIO jfw=new JsonFileIO();
		jfw.writeFile("First.json",player);*/
	}

}


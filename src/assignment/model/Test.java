package assignment.model;


import assignment.util.InterfaceAdapter;
import assignment.util.JsonFileIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class Test {
	public static void main(String[] args) {
		/*String s=" ";
		boolean b=s.matches("[*+-/()0-9x\\s]")&&!s.matches("[.,]");
		System.out.println(b);*/
		/*
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
				.create();
		try{
			BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+"First.json"));
			Player player=gson.fromJson(br,Player.class);
			System.out.println(player.getName());
		}catch(Exception e){
			e.printStackTrace();
		}*/

		Player player=new Player();
		player.setName("player2");
		Round round =new Round();
		round.setLevel(new Customize());
		round.setScore(2);
		round.setAttempts(10);
		Round round1 =new Round();
		round1.setLevel(new Customize());
		round1.setScore(2);
		round1.setAttempts(10);
		player.addRound(round);
		player.addRound(round1);


		JsonFileIO jfw=new JsonFileIO();
		jfw.writeFile("First.json",player);
		//Player player1= (Player) jfw.readFile("First.json");
		//System.out.println(player1.getName());


		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
				.registerTypeAdapter(Level.class,new InterfaceAdapter<Level>())
				.create();
		try{
			BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+"First.json"));
			Player player1=gson.fromJson(br,Player.class);
			System.out.println(player1.getRounds(Level.Levels.CUSTOMIZE));
		}catch(Exception e){
			e.printStackTrace();
		}



	}

}


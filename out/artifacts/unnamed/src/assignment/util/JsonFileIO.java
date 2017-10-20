package assignment.util;

import assignment.model.Level;
import assignment.model.Player;
import assignment.model.PlayerRecorder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class JsonFileIO {


    public void writeFile(String fileName,Object object){
        Gson gson=new GsonBuilder()
                .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
                .registerTypeAdapter(Level.class,new InterfaceAdapter<Level>())
                .create();
        String json=gson.toJson(object);

        try{
            FileWriter writter =new FileWriter(new File(".").getAbsolutePath()+fileName);
            writter.write(json);
            writter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Player readFile(String fileName){
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
                .registerTypeAdapter(Level.class,new InterfaceAdapter<Level>())
                .create();
        try{
            BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+fileName));
            Player player=gson.fromJson(br,Player.class);
            return player;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PlayerRecorder readRecorder(String fileName){
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
                .registerTypeAdapter(Level.class,new InterfaceAdapter<Level>())
                .create();
        try{
            BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+fileName));
            PlayerRecorder recorder=gson.fromJson(br,PlayerRecorder.class);
            return recorder;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


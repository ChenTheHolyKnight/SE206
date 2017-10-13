package assignment.util;

import assignment.model.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class JsonFileIO {


    public void writeFile(String fileName,Object object){
        Gson gson=new GsonBuilder().registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
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

    public void readFile(String fileName,Object object){
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
                .create();
        try{
            BufferedReader br = new BufferedReader( new FileReader(new File(".").getAbsolutePath()+fileName));
            Player player=gson.fromJson(br,Player.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


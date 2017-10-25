package assignment.util;

import assignment.model.Level;
import assignment.model.PlayerRecorder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Modifier;
import java.util.List;

import static assignment.util.ObservableListTypeAdapterFactory.getObservableListTypeAdapterFactory;

public class JsonFileIO {
    private Gson _gson;
    public JsonFileIO(){
        _gson=new GsonBuilder()
                .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
                .registerTypeAdapter(Level.class,new InterfaceAdapter<Level>())
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .create();
    }


    public void writeFile(String fileName,Object object){
        String json=_gson.toJson(object);
        try{
            FileWriter writter =new FileWriter(new File(" ").getAbsolutePath()+fileName);
            writter.write(json);
            writter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> readQuestionFile(File file){
        try{
            BufferedReader br = new BufferedReader( new FileReader(file));
            List<String> questions=_gson.fromJson(br,List.class);
            return questions;
        }catch(Exception e){

        }
        return null;
    }

    public PlayerRecorder readRecorder(String fileName){
        try{
            BufferedReader br = new BufferedReader( new FileReader(new File(" ").getAbsolutePath()+fileName));
            PlayerRecorder recorder=_gson.fromJson(br,PlayerRecorder.class);
            return recorder;
        }catch(Exception e){

        }
        return null;
    }
}


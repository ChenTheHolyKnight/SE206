package assignment.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	private List<String> _recordFile;
	public FileReader(){
		_recordFile=new ArrayList<String>();
		readFile();
		trimFile();
	}
	
	private void readFile() {
		//System.out.println(System.getProperty("user.dir")+"/recout.mlf");
		//System.out.println(getClass().getClassLoader().getResource(".").toString());
		//System.out.println(getClass().getResource("../../recout.mlf").toString());
		try (Scanner scanner=new Scanner(new File(System.getProperty("user.dir")+"/recout.mlf"))){
			while(scanner.hasNextLine()) {
				_recordFile.add(scanner.nextLine());
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void trimFile() {
		_recordFile.remove(0);
		_recordFile.remove(0);
		_recordFile.remove(0);
		_recordFile.remove(_recordFile.size()-1);
		_recordFile.remove(_recordFile.size()-1);
	}
	public List<String> getRecordFile(){
		return _recordFile;
	}
	
}

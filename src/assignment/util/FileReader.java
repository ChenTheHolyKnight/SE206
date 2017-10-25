package assignment.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	private List<String> _recordFile;
	public FileReader() {
		_recordFile=new ArrayList<String>();
		readFile();
		try {
			trimFile();
		}catch (Exception e) {
			
		}
	}
	
	private void readFile() {
		try (Scanner scanner=new Scanner(new File(System.getProperty("user.dir")+"/recout.mlf"))){
			while(scanner.hasNextLine()) {
				_recordFile.add(scanner.nextLine());
			}
		}catch(IOException e) {
			//e.printStackTrace();
		}
	}
	
	private void trimFile() throws Exception{
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

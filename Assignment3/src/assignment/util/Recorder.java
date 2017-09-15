package assignment.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recorder {/*
	private String _name;
	public Recorder(String name) {
		_name=name;
	}*/
	public void printpwd() {
		String cmd = "pwd";
		ProcessBuilder pb=new ProcessBuilder("bash","-c",cmd);
		try {
			Process process=pb.start();
			BufferedReader stderr=new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line="";
			while((line=stderr.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void record() {
		try {
			String cmd="arecord -d 3 -r 22050 -c 1 -i -t wav -f s16_LE "+"foo.wav";
			ProcessBuilder pb=new ProcessBuilder("bash","-c",cmd);
			Process process=pb.start();
			int exitValue=process.waitFor();
			if(exitValue==0) {
				process.destroy();
			}else {
				System.out.println("PENIS");
				process.destroy();
			}
		}catch(Exception e) {

		}
	}
	
	public void recordToWord() {
		try {
			String cmd ="HVite -H HTK/MaoriNumbers/HMMs/hmm15/macros -H HTK/MaoriNumbers/HMMs/hmm15/hmmdefs -C HTK/MaoriNumbers/user/configLR  -w HTK/MaoriNumbers/user/wordNetworkNum -o SWT -l '*' -i recout.mlf -p 0.0 -s 5.0  HTK/MaoriNumbers/user/dictionaryD HTK/MaoriNumbers/user/tiedList foo.wav";
			ProcessBuilder pb=new ProcessBuilder("bash","-c",cmd);
			Process process=pb.start();
			/*BufferedReader stderr=new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line="";
			while((line=stderr.readLine())!=null) {
				System.out.println(line);
			}*/
			
			int exitValue=process.waitFor();
			if(exitValue==0) {
				process.destroy();
			}else {
				System.out.println("PENIS");
				process.destroy();
			}
		}catch(Exception e){
			
		}
	}
}

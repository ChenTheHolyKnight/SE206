package assignment.util;



public class Recorder {

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
			e.printStackTrace();
		}
	}
	
	public void recordToWord() {
		try {
			String cmd ="HVite -H HTK/MaoriNumbers/HMMs/hmm15/macros -H HTK/MaoriNumbers/HMMs/hmm15/hmmdefs -C HTK/MaoriNumbers/user/configLR  -w HTK/MaoriNumbers/user/wordNetworkNum -o SWT -l '*' -i recout.mlf -p 0.0 -s 5.0  HTK/MaoriNumbers/user/dictionaryD HTK/MaoriNumbers/user/tiedList foo.wav";
			ProcessBuilder pb=new ProcessBuilder("bash","-c",cmd);
			Process process=pb.start();
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
	
	public void deleteRecord() {
		try {
			String cmd="rm foo.wav";
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
			e.printStackTrace();
		}
	}
	
	public void playRecord() {
		try {
			String cmd="ffplay -nodisp foo.wav -autoexit";
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
			e.printStackTrace();
		}
	}
}

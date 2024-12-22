package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	private static String logFile = "system.log";
		
	public static void write(String content) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(logFile), true));
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

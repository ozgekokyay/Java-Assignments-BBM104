
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadfromFile {
	/*
	 * read txt file
	 */
	
	public static String[] readFile(String path) {
		try {
			int i=0;
			int length= Files.readAllLines(Paths.get(path)).size();
			String[] results= new String[length];
				for (String line: Files.readAllLines(Paths.get(path))) {
					results[i++]=line;
				}
			return results;
			
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}

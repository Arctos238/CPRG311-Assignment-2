package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOManager {
	public IOManager() {
		
	}
	
	public Scanner openFile(String fileLocation) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileLocation));
		return fileReader;
	}
	
	public void closeFile(Scanner fileToClose) {
		fileToClose.close();
	}
}

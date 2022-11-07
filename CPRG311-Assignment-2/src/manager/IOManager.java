package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Class IOManager.
 */
public class IOManager {
	
	/**
	 * Instantiates a new IO manager.
	 */
	public IOManager() {
		
	}
	
	/**
	 * This method returns a scanner object once passed through a fileLocation.
	 * @param fileLocation the file location
	 * @return the scanner for the file
	 * @throws FileNotFoundException the file not found exception
	 */
	public Scanner openFile(String fileLocation) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileLocation));
		return fileReader;
	}
	
}

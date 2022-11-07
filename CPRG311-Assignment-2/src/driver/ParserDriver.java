package driver;

import java.io.FileNotFoundException;
import java.util.*;
import manager.*;
import utilities.*;

/**
 * The Class ParserDriver. This is the driver of the application.
 */
public class ParserDriver {
	/**
	 * The main method of the program. The program will first ask the user where the
	 * file is located to parse This method will called upon the methods in the two
	 * manager programs. The first manager program controls the input and out of
	 * retrieving files. The second manager program parses the XML file and prints
	 * the error queue log.
	 * 
	 * @param None to be passed through
	 * @exception FileNotFoundException  if no file has been found at that location
	 *                                   the file will crash and print a message
	 *                                   saying that no file has been found a that
	 *                                   location.
	 * @exception NoSuchElementException is used to catch if no log has been found.
	 */
	public static void main(String[] args) {
		IOManager ioManager = new IOManager();
		ParserManager pManager = new ParserManager();
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the file location: ");
		String fileProvided = in.nextLine().replaceAll("\"", "");

		try {
			Scanner fileScanner = ioManager.openFile(fileProvided); // Opens a scanner file with the location of
																	// file one;
			MyQueue<String> errorQueue = pManager.parseXML(fileScanner); // Return the error Queue for the first
																			// file
			pManager.printErrorQueue(errorQueue, fileProvided); // Prints the error queue for the second file
		} catch (FileNotFoundException e) {
			System.out.println(
					"No File in that location has been found. Please restart application and enter a valid file path.");
		} catch (NoSuchElementException e) {
			System.out.println("No element has been found in that stack or queue.");
		}
		
		in.close();
	}
}

package driver;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyQueueException;
import manager.IOManager;
import manager.ParserManager;
import utilities.*;

public class ParserDriver {
	private final static String FILE_LOCATION_ONE = "res\\sample1.xml";
	private final static String FILE_LOCATION_TWO = "res\\sample2.xml";

	public static void main(String[] args) {
		IOManager ioManager = new IOManager();
		ParserManager pManager = new ParserManager();

		

		try {
			System.out.println();
			Scanner fileScanner = ioManager.openFile(FILE_LOCATION_ONE);
			MyQueue<String> errorQueue =  pManager.parseXML(fileScanner);
			pManager.printErrorQueue(errorQueue);
			
			System.out.println();
			fileScanner = ioManager.openFile(FILE_LOCATION_TWO);
			errorQueue =  pManager.parseXML(fileScanner);
			pManager.printErrorQueue(errorQueue);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}

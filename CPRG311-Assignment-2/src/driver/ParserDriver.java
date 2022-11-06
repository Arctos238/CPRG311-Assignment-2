package driver;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

		MyQueue<String> eQueue = new MyQueue<>();
		MyStack<String> stack = new MyStack<>();

		try {
			Scanner fileScanner = ioManager.openFile(FILE_LOCATION_TWO);

			while (fileScanner.hasNext()) {
				String line = fileScanner.nextLine().trim();

				String[] tags = line.split(" ");
				
				for(int i = 0; i < tags.length; i++) {
					System.out.println(tags[i]);
				} 
				System.out.println();

			}

			fileScanner.close();



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		Iterator<String> it = eQueue.iterator();
		System.out.println("Queue Starts:");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

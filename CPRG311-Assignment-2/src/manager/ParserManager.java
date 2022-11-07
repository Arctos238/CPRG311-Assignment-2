package manager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.MyQueue;
import utilities.MyStack;

/**
 * The Class ParserManager.
 */
public class ParserManager {

	/**
	 * Instantiates a new parser manager.
	 */
	public ParserManager() {

	}

	/**
	 * Parses the XML. This method will read through the file until its at the end of the file.
	 * If not error are found then an empty exception queue will be returned.
	 * This method will parse the XML file by looking for tags with regex. 
	 * It will put each tag into the stack if the tag does not have a self closing tag or does not contain a ? at the start
	 * or is not a closing tag.
	 * If the tag is a closing tag it will pop off the stack and check if they are same tags. If they are not
	 * the same tag then the line will be put into the error queue along side the tag that was invalid.
	 * @param fileScanner the file scanner with the file loaded inside the scanner object.
	 * @return will return an error queue log with all the error it found inside the file.
	 */
	public MyQueue<String> parseXML(Scanner fileScanner) {
		MyQueue<String> eQueue = new MyQueue<>();
		MyStack<String> stack = new MyStack<>();

		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine().trim();

			// Creating a pattern object
			Pattern pattern = Pattern.compile("<([\\s\\S]*?)>");
			// Matching the compiled pattern in the String
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				String result = matcher.group(1);
				
				// If the tag starts with a ? ignore
				if (!result.startsWith("?")) {
					// If the tag ends with / then it is a self closing tag and will ignore
					if (!result.endsWith("/")) {
						// Splits the results up so that it can grab the tag at the start inside of the tag.
						String[] splitResults = result.split(" ");
						// Obtains the tag name
						result = splitResults[0];
						// Checks if the tag is a closing tag
						if (result.startsWith("/")) {
							// If the closing tag matches with the top of the stack then it will pop the tag off
							if (result.substring(1, result.length()).equals(stack.peek())) {
								stack.pop();
							} else {
								// If it does not then it will add theses tags and the line to the queue
								eQueue.enqueue(
										"Error: " + stack.pop() + " does not equal " + result + " on this " + line);
							}
						} else {
							// If its not a self closing tag then it will add the tag to the stack
							stack.push(result);
						}
					}
				}
			}	
		}
		
		// Will put the remaining stack items into the queue.
		Iterator<String> it = stack.iterator();
		while(it.hasNext()) {
			eQueue.enqueue("Error left over in stack item: " + it.next());
			}
		
		//Closes the file
		fileScanner.close();

		return eQueue;
	}

	/**
	 * This method will check if the queue is empty. If the queue is empty then it will print no errors found.
	 * If the queue it not empty then it will print each error that it found when parsing
	 *
	 * @param errorQueue the error queue
	 */
	public void printErrorQueue(MyQueue<String> errorQueue, String fileName) {
		if (errorQueue.isEmpty()) {
			System.out.println("No Errors found for file name: " + fileName);
		} else {
			System.out.println("Error Queue Log for file name: " + fileName);
			try {
				while (errorQueue.peek() != null) {
					System.out.println(errorQueue.dequeue());
				}
			} catch (EmptyQueueException e) {
				System.out.println("End of Error Queue Log");
			}
		}
		
		
	}
}

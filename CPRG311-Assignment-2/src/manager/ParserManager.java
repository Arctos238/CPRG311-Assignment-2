package manager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.MyQueue;
import utilities.MyStack;

public class ParserManager {

	public ParserManager() {

	}

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

				if (!result.startsWith("?")) {
					if (!result.endsWith("/")) {
						String[] splitResults = result.split(" ");
						result = splitResults[0];
						if (result.startsWith("/")) {
							if (result.substring(1, result.length()).equals(stack.peek())) {
								stack.pop();
							} else {
								eQueue.enqueue(
										"Error: " + stack.pop() + " does not equal " + result + " on this " + line);
							}
						} else {
							stack.push(result);
						}
					}
				}
			}	
		}

		Iterator<String> it = stack.iterator();
		while(it.hasNext()) {
			eQueue.enqueue("Error left over in stack item: " + it.next());
			}
		fileScanner.close();

		return eQueue;
	}

	public void printErrorQueue(MyQueue<String> errorQueue) {
		System.out.println("Error Queue Log:");
		try {
			while (errorQueue.peek() != null) {
				System.out.println(errorQueue.dequeue());
			}
		} catch (EmptyQueueException e) {

			System.out.println("Queue is empty");

		}
		System.out.println("End of Error Queue Log");
	}
}

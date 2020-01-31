package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

import hw1.pojo.Node;

public class ProblemThree {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		
		int noOfElements = 100000; 
		if(args[0] != null) {
			Node head = new Node();
						
			noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			IntStream randomNumStream = randomObj.ints(noOfElements, 1, noOfElements+1);// 1 unit time
			
			int[] randomNumbers = randomNumStream.toArray();
			/*
			 * System.out.println("Generated Numbers--->"); for(int num : randomNumbers) {
			 * System.out.print(" "+num); }
			 */
			
			//Creating first node and making head to point first node
			Node firstNode = new Node(randomNumbers[0],null);
			//Making head to point the first node
			head.setNextNode(firstNode);
			
			Node previousNode = firstNode;
			Node currentNode = null;
			for(int index=1; index < randomNumbers.length; index++) {// n times
				currentNode = createNode(randomNumbers[index]);// 2 unit time
				//assigning the next node value for each node
				previousNode.setNextNode(currentNode);// 1 unit time
				previousNode = currentNode;// 1 unit time		
				
			}
			/*
			 * System.out.println(""); System.out.println("Node Elements --->");
			 * printNode(head.getNextNode());
			 */	
			
							
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in ms : Numbers stored in linked list without order ---->  "+executionTime);
			

	}

	private static void printNode(Node head) {
		
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(" "+currentNode);
			currentNode = currentNode.getNextNode();
		}
		
	}

	private static Node createNode(int data) {// 2 unit time
		Node node = new Node(data, null);
		return node;
		
	}

}

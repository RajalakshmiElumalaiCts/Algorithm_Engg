package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import hw1.pojo.Node;

public class ProblemThree {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		
		int noOfElements = 100000; 
		if(args[0] != null) {
			Node head = null;
			Node previousNode = null;
						
			noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			for(int count=0; count < noOfElements; count++) {// n time
				int randomNumber = 1 + randomObj.nextInt(noOfElements);
				Node currentNode = new Node(randomNumber);
				if(head == null) {
					//head pointing first node
					head = currentNode;
				}else {
					previousNode.setNextNode(currentNode);					
				}
				previousNode = currentNode;
			}					
			/*
			 * System.out.println("Node Elements --->"); printNode(head);
			 */				
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in ms : Numbers stored in linked list without order ---->  "+executionTime);
			

	}

	private static void printNode(Node head) {
		
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(" "+currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
		
	}

}

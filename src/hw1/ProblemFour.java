package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import hw1.pojo.Node;

public class ProblemFour {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		Node head = null;
		Node previousNode = null;
		
		int noOfElements; 
		if(args[0] != null) {
						
			noOfElements = Integer.parseInt(args[0]);
			System.out.println("noOfElements --->"+noOfElements);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			for(int count=0; count < noOfElements; count++) { // n times
				int randomNumber = 1 + randomObj.nextInt(noOfElements);
				Node newNode = new Node(randomNumber);
				if(head == null) {
					//head pointing first node
					head = newNode;
					previousNode = newNode;
				}else {
					if(previousNode.getData() <= randomNumber) {
						//just append the current node, as previous element is smaller one
						previousNode.setNextNode(newNode);
						previousNode = newNode;
					}else {
						head = findPositionAndRtnHead(head, newNode); // n/2 or avg
					}					
				}				
			}	
			
			/*
			 * System.out.println(""); System.out.println("Node Elements --->");
			 * printNode(head);
			 */
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in ms : Sorted linked list  ---->  "+executionTime);
		
		
	}
		
		private static Node findPositionAndRtnHead(Node head, Node newNode) {
			Node currentNode = head;
			Node previous = null;
			while(currentNode != null) {//avg - n/2 
				if(currentNode.getData() >= newNode.getData()) {
					if(currentNode == head) {
						newNode.setNextNode(currentNode);
						head = newNode;						
						break;
					}else {
						newNode.setNextNode(currentNode);
						previous.setNextNode(newNode);
						break;
					}
					
				}
				previous = currentNode;
				currentNode = currentNode.getNextNode();
			}	
			 return head;
	}
		private static void printNode(Node head) {
			
			Node currentNode = head;
			while(currentNode != null) {
				System.out.print(" "+currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			
		}	

}

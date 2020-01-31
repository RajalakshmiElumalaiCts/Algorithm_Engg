package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

import hw1.pojo.Node;

public class ProblemFour {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		
		int noOfElements = 100000; 
		if(args[0] != null) {
						
			noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			IntStream randomNumStream = randomObj.ints(noOfElements, 1, noOfElements+1);	
			
			int[] randomNumbers = randomNumStream.toArray();
			/*
			 * System.out.println("Generated Numbers--->"); for(int num : randomNumbers) {
			 * System.out.print(" "+num); }
			 */
			
			int smallNum, tempNum, smallNumIndex;
			Node previousNode = null;
			Node currentNode = null;
			Node head = new Node();
			
			//Sorting the array of data
			 for(int i=0; i < randomNumbers.length; i++) {
				 smallNum = randomNumbers[i];
				 smallNumIndex = i;	
				 for(int j=i+1; j < randomNumbers.length; j++) {					 
					 if(smallNum > randomNumbers[j]) {
						 smallNum = randomNumbers[j];
						 smallNumIndex = j;	
					 }					 
				 }	
				 //saves the smallest element in the original array to
				 //compare the remaining not sorted numbers
				 tempNum = randomNumbers[i];
				 randomNumbers[i] = smallNum;
				 randomNumbers[smallNumIndex] = tempNum;
				 
				 //create node for the small element
				 currentNode = createNode(smallNum);
				 if(i == 0) {// Making head to point first node
					 head.setNextNode(currentNode);	 
				 }	
				 if(previousNode != null) {
					//assigning the next node value for each node
					 previousNode.setNextNode(currentNode);
				 }
				 previousNode = currentNode;	
								 
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

		private static Node createNode(int data) {
			Node node = new Node(data, null);
			return node;
			
		}

}

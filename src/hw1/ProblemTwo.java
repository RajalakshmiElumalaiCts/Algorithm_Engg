package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class ProblemTwo {

	public static void main(String[] args) {
		Instant startTime = Instant.now();

		int noOfElements = 0;
		int[] randomArray;
		if(args[0] != null) {
			
			noOfElements = Integer.parseInt(args[0]);
			randomArray = new int[noOfElements];
			//Generate Random Numbers
			Random randomObj = new Random();
			int randomNumber;
			for(int count=0; count < noOfElements; count++) { // n time
				randomNumber = 1 + randomObj.nextInt(noOfElements);
				placeInArray(randomArray, randomNumber);// n^2/4 or log^2 n
			}
			/*
			 * System.out.println("After Sorting--------->");//ignore for(int count=0; count
			 * < noOfElements; count++) { System.out.println(randomArray[count]); }
			 */
			 
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Generated Numbers and sorted ---->  "+executionTime);		
	}

	private static void placeInArray(int[] randomArray, int randomNumber) {  // n^2/4 or log^2 n
		boolean elementPlaced = false;
		int index = 0;
		 for(; index<randomArray.length; index++) { // n times exe, avg n/2, log n
			 if(randomArray[index] == 0) {
				 break;
			 }
			 if(randomArray[index] > randomNumber) {
				 insertNewNumber(randomArray,index,randomNumber);  // n/2 or log n
				 elementPlaced = true;
				 break;
			 }
		 }
		 if(!elementPlaced && index < randomArray.length) {
			 randomArray[index] = randomNumber;
		 }
	}

	private static void insertNewNumber(int[] randomArray, int index, int randomNumber) {
		int currentNum = randomNumber;
		int tempNum = 0;
		 for(int idx= index; (idx < randomArray.length && currentNum != 0); idx++) {// avg n/2 or log n
			 tempNum = randomArray[idx];
			 randomArray[idx] = currentNum; 
			 currentNum = tempNum;
		 }		 
	}

}

package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.ElementCounter;

public class ProblemThree {

	public static void main(String[] args) {

		Instant startTime = Instant.now();
		
		ElementCounter counter = new ElementCounter();
		
		//Map to record each element’s occurrences
		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); 
		
		int n_noOfElements, generatedNumber; 
		int randomNumbers[];
		if(args[0] != null) {
			n_noOfElements = Integer.parseInt(args[0]);
			randomNumbers = new int[n_noOfElements];
			
			//Generate n random numbers between 1 & m_maxNumber for an iteration				
			for(int numCount = 0; numCount < n_noOfElements; numCount++) {//n times
				generatedNumber = new Random().nextInt((3+1)-1) + 1;
				
				//Adds the new number into array
				randomNumbers[numCount] = generatedNumber;
				
			}
			 			
			/*
			 * for(int num : randomNumbers) { // n times will get executed.ignore
			 * System.out.print(" "+num); } System.out.println(" After sorting");
			 */
			
			
			 bubbleSort(randomNumbers);//O[(n^2) - 5n]
			 
			
			/*
			 * for(int num : randomNumbers) { // n times will get executed.ignore
			 * System.out.print(" "+num); }
			 */
			
			 
			 counter.countElemnet(randomNumbers, elementCountMap); // O(n)
			 System.out.println("Elements count-----> "+elementCountMap);
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Problem Three ---->  "+executionTime);
		

	}

	/*
	 * Each number is compared with all the previous numbers and swaps when it finds greater number
	 * in previous position
	 */
	private static void bubbleSort(int[] randomNumbersArray) {
		int temp;
		for (int i = 1; i < randomNumbersArray.length; i++) {// n time
			for (int j = i - 1; j >= 0; j--) {//n-1 time
				if (randomNumbersArray[j] > randomNumbersArray[i]) {
					temp = randomNumbersArray[j];
					randomNumbersArray[j] = randomNumbersArray[i];
					randomNumbersArray[i] = temp;
					i = j;
				}

			}

		}

	}

}

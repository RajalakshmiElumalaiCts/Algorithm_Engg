package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import util.ElementCounter;

public class ProblemThree {

	public static void main(String[] args) {

		Instant startTime = Instant.now();
		
		ElementCounter counter = new ElementCounter();
		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); 
		
		int n_noOfElements; 
		if(args[0] != null) {
			n_noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			IntStream randomNumners = randomObj.ints(n_noOfElements, 1, 3+1); // 1 sec = O(1)
			
			
			 //Storing data exists in Stream to Array
			 int[] randomNumbersArray = randomNumners.toArray();
			 
			
			/*
			 * for(int num : randomNumbersArray) { // n times will get executed.ignore
			 * System.out.print(" "+num); } System.out.println(" After sorting");
			 */
			
			 bubbleSort(randomNumbersArray);//O[(n^2) - 5n]
			 
			/*
			 * for(int num : randomNumbersArray) { // n times will get executed.ignore
			 * System.out.print(" "+num); }
			 */
			 
			 counter.countElemnet(randomNumbersArray, elementCountMap); // O(n)
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

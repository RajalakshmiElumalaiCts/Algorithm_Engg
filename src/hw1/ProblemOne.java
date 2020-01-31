package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

public class ProblemOne {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		
		int noOfElements; 
		if(args[0] != null) {
			noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			IntStream randomNumners = randomObj.ints(noOfElements, 1, noOfElements+1); // 1 sec = O(1)
			
			//randomNumners.forEach(num -> System.out.print(" "+num) );						
			
			 //Storing data exists in Stream to Array
			 int[] randomNumbersArray = randomNumners.toArray();
			 
			/*
			 * for(int num : randomNumbersArray) { // n times will get executed.ignore
			 * System.out.print(" "+num); }
			 */		
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Generated Numbers without order ---->  "+executionTime);
		
		

	}

}

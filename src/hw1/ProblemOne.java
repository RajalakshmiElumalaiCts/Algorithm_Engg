package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class ProblemOne {

	public static void main(String[] args) {
		Instant startTime = Instant.now();
		
		int noOfElements;
		int[] randomNumbersArray;
		
		if(args[0] != null) {
			noOfElements = Integer.parseInt(args[0]);
			randomNumbersArray = new int[noOfElements];
			System.out.println("noOfElements --->"+noOfElements);
			//Generate Random Numbers
			Random randomObj = new Random();
			for(int count=0; count < noOfElements; count++) {// O(n)
				//return an integer between 0 and noOfElements (exclusive), 
				//then add min value 1 to get values from 1 to n
				randomNumbersArray[count] = 1 + randomObj.nextInt(noOfElements);
				
			}	
			
			/*
			 * for(int count=0; count < noOfElements; count++) {
			 * System.out.println(randomNumbersArray[count]); }
			 */
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Problem One ---->  "+executionTime);	

	}

}

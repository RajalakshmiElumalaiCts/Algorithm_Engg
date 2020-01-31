package hw1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

public class ProblemTwo {

	public static void main(String[] args) {
		Instant startTime = Instant.now();

		int noOfElements = 100000; 
		if(args[0] != null) {
			
			noOfElements = Integer.parseInt(args[0]);
			
			//Generate Random Numbers
			Random randomObj = new Random();
			IntStream randomNumners = randomObj.ints(noOfElements, 1, noOfElements+1);// O(1)
						
			 //Storing data exists in Stream to Array
			 int[] randomArray = randomNumners.toArray();
			 
			/*
			 * System.out.println("Before Sorting--------->");//ignore for(int num :
			 * randomArray) { System.out.print(" "+num); } System.out.println("");
			 */
			 int smallNumIndex, smallNum, tempNum;
			 //Sorting the array of data
			 for(int i=0; i<randomArray.length; i++) { // n times exe
				 smallNum = randomArray[i];
				 smallNumIndex = i;	
				// for each of above n iteration , it gets executed for n-1 times
				 for(int j=i+1; j < randomArray.length; j++) {	 				 
					 if(smallNum > randomArray[j]) {
						 smallNum = randomArray[j];
						 smallNumIndex = j;	
					 }					 
				 }	
				 //n times exe = n(1+1+1)
				 tempNum = randomArray[i];//1
				 randomArray[i] = smallNum;//1 
				 randomArray[smallNumIndex] = tempNum;//1				 
			 }
			 			 
			/*
			 * System.out.println("After Sorting--------->");//ignore for(int num :
			 * randomArray) { System.out.print(" "+num); }
			 */
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Generated Numbers and sorted ---->  "+executionTime);
		
		

	}

}

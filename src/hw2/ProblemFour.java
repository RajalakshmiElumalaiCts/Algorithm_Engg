package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import util.ElementCounter;

public class ProblemFour {
	
	static int[] randomNumbersArray;

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
			 randomNumbersArray = randomNumners.toArray();
			 
			
			/*
			 * for(int num : randomNumbersArray) { // n times will get executed.ignore
			 * System.out.print(" "+num); } System.out.println(" After sorting");
			 */
			
			 sort(randomNumbersArray);
			 
			/*
			 * for(int num : randomNumbersArray) { // n times will get executed.ignore
			 * System.out.print(" "+num); }
			 */
			 
			 counter.countElemnet(randomNumbersArray, elementCountMap);//n 
			 System.out.println("Elements count-----> "+elementCountMap);
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Generated Numbers without order ---->  "+executionTime);
			
	}
	
	 private static void sort(int[] inputArr) {         
	       
	        quickSort(0, inputArr.length - 1);
	 }
	 
	 private static void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, taking pivot as middle index number
	        int pivot = randomNumbersArray[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {//j-i, upperIndex - lowerIndex time
	            /**
	             * In each iteration, we will identify a number from left side which 
	             * is greater then the pivot value, and also we will identify a number 
	             * from right side which is less then the pivot value. Once the search 
	             * is done, then we exchange both numbers.
	             */
	            while (randomNumbersArray[i] < pivot) {//lowerIndex+[ (higherIndex-lowerIndex)/2 ] time
	                i++;
	            }
	            while (randomNumbersArray[j] > pivot) {//{upperIndex - [(higherIndex-lowerIndex)/2] } +1]
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);//O(3)
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private static void exchangeNumbers(int i, int j) {
	        int temp = randomNumbersArray[i];
	        randomNumbersArray[i] = randomNumbersArray[j];
	        randomNumbersArray[j] = temp;
	    }

}

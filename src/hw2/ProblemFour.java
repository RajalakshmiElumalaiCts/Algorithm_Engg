package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.ElementCounter;

public class ProblemFour {
	

	public static void main(String[] args) {


		Instant startTime = Instant.now();
		
		ElementCounter counter = new ElementCounter();
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
						
			 sort(randomNumbers);		 
			
			/*
			 * for(int num : randomNumbers) { // n times will get executed.ignore
			 * System.out.print(" "+num); }
			 */
			
			 
			 counter.countElemnet(randomNumbers, elementCountMap);//n 
			 System.out.println("Elements count-----> "+elementCountMap);
			
		}
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Generated Numbers without order ---->  "+executionTime);
			
	}
	
	 private static void sort(int[] inputArr) {         
	       
	        quickSort(0, inputArr.length - 1, inputArr);
	 }
	 
	 private static void quickSort(int lowerIndex, int higherIndex, int[] inputArr) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, taking pivot as middle index number
	        int pivot = inputArr[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {//j-i, upperIndex - lowerIndex time
	            /**
	             * In each iteration, we will identify a number from left side which 
	             * is greater then the pivot value, and also we will identify a number 
	             * from right side which is less then the pivot value. Once the search 
	             * is done, then we exchange both numbers.
	             */
	            while (inputArr[i] < pivot) {//lowerIndex+[ (higherIndex-lowerIndex)/2 ] time
	                i++;
	            }
	            while (inputArr[j] > pivot) {//{upperIndex - [(higherIndex-lowerIndex)/2] } +1]
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j, inputArr);//O(3)
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j, inputArr);
	        if (i < higherIndex)
	            quickSort(i, higherIndex, inputArr);
	    }
	 
	    private static void exchangeNumbers(int i, int j, int[] inputArr) {
	        int temp = inputArr[i];
	        inputArr[i] = inputArr[j];
	        inputArr[j] = temp;
	    }

}

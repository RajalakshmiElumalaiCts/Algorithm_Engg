package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.DuplicateRemover;
import util.ElementCounter;

public class ProblemTwo {

	public static void main(String[] args) {

		Instant startTime = Instant.now();
		
		DuplicateRemover remover = new DuplicateRemover();
		ElementCounter counter = new ElementCounter();
		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); 
		int totalElemnetCount = 0;
		
		
		
		int n_noOfElements, p_iterations, m_maxNumber, generatedNumber;
		if(args != null && args.length == 3) {
			n_noOfElements = Integer.parseInt(args[0]);
			m_maxNumber = Integer.parseInt(args[1]);
			p_iterations = Integer.parseInt(args[2]);
			int arrayIndex;
			int[] randomNumbers = new int[n_noOfElements];
			int[] nonDuplicatedNumbers;
			
			//iterating p times
			for(int iteCount = 0; iteCount < p_iterations; iteCount++ ) {// p time
				arrayIndex = 0; 
				
				//Generate Random Numbers between 1 & m_maxNumber for an iteration
				for(int numCount = 0; numCount < n_noOfElements; numCount++) { // n time
					generatedNumber = new Random().nextInt((m_maxNumber+1)-1) + 1;
					
					//Adds the new number into array, if the new number not exists
					if(!remover.isDuplicated(randomNumbers, generatedNumber,arrayIndex)) {// n-1 time
						randomNumbers[arrayIndex] = generatedNumber;
						arrayIndex++;
					}					
				}
				
				//Copying randomNumbers array to nonDuplicatedNumbers to remove the numbers(0) which were added in default 
				nonDuplicatedNumbers = new int[arrayIndex-1];
				nonDuplicatedNumbers = remover.removeDefaultValues(randomNumbers,nonDuplicatedNumbers);//best case = 0, worst case = n-1				
								
				
				 //System.out.println("After-----"); //after removing duplicates
				 //for(int num :	 nonDuplicatedNumbers) { System.out.print(" "+num); } System.out.println("");
				
				
				//counts each element occurrence 
				counter.countElemnet(nonDuplicatedNumbers,elementCountMap);//n
				totalElemnetCount = totalElemnetCount + nonDuplicatedNumbers.length;
				
			}		
			
		}
		
		/*
		 * System.out.println("Elements total Count for all iteration --->"
		 * +totalElemnetCount);
		 * System.out.println("Each Elements count-----> "+elementCountMap);
		 */
		
		Map<Integer, String> elementProbabilityMap = counter.calculateElementProbability(totalElemnetCount,elementCountMap);//n time		
		//System.out.println("Elements probability --->"+elementProbabilityMap);
		
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("Execution Time in Milli Seconds : Problem Tne ---->  "+executionTime);
	}

}

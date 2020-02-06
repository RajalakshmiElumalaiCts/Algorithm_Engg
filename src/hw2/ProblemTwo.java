package hw2;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import util.DuplicateRemover;
import util.ElementCounter;

public class ProblemTwo {

	public static void main(String[] args) {

		Instant startTime = Instant.now();
		
		DuplicateRemover remover = new DuplicateRemover();
		ElementCounter counter = new ElementCounter();
		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); 
		int totalElemnetCount = 0;
		
		
		
		int n_noOfElements, p_iterations, m_maxNumber;
		if(args != null && args.length == 3) {
			n_noOfElements = Integer.parseInt(args[0]);
			m_maxNumber = Integer.parseInt(args[1]);
			p_iterations = Integer.parseInt(args[2]);
			
			//iterating p times
			for(int iteCount = 0; iteCount < p_iterations; iteCount++ ) {// p time
				//Generate Random Numbers between 1 & m_maxNumber for an iteration
				Random randomObj = new Random();
				IntStream randomStream = randomObj.ints(n_noOfElements, 1, m_maxNumber+1); // 1 sec = O(1)				
				int[] randomNumbers = randomStream.toArray();
				
				/*
				 * //before removing duplicates System.out.println("before----------"); for(int
				 * num : randomNumbers) { System.out.print(" "+num); } System.out.println("");
				 */
				
				 //removing duplicates				
				randomNumbers = remover.removeDuplicate(randomNumbers);// O(n^2)
				/*
				 * System.out.println("After-----"); //after removing duplicates for(int num :
				 * randomNumbers) { System.out.print(" "+num); } System.out.println("");
				 */
				
				//counts each element occurrence 
				counter.countElemnet(randomNumbers,elementCountMap);//O(n)
				totalElemnetCount = totalElemnetCount + randomNumbers.length;
				
			}
			
			
		}
		
		System.out.println("Elements total Count for all iteration --->"+totalElemnetCount);
		System.out.println("Each Elements count-----> "+elementCountMap);
		
		Map<Integer, String> elementProbabilityMap = counter.calculateElementProbability(totalElemnetCount,elementCountMap);//O(n)		
		System.out.println("Elements probability --->"+elementProbabilityMap);
		
		Instant endTime = Instant.now();
		long executionTime = Duration.between(startTime, endTime).toMillis();
		System.out.println("\nExecution Time in Milli Seconds : Problem One ---->  "+executionTime);
	}

}

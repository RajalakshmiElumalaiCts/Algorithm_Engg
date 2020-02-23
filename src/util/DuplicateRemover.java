package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DuplicateRemover {
	
	public int[] removeDuplicate(int[] duplicateNumbers) {
		Map<Integer, Integer> elementWithCount = new HashMap<Integer, Integer>();
		
		int count = 0;
		for(int i=0; i < duplicateNumbers.length; i++) {// n time execution
			if(!checkElementCounted(duplicateNumbers[i], elementWithCount)) {
				count++;
				for(int j=i+1; j < duplicateNumbers.length; j++) {// n-1 time
					if(duplicateNumbers[i] == duplicateNumbers[j]) {
						count++;
					}					
				}
				elementWithCount.put(duplicateNumbers[i], count);
				count = 0;				
			}			
		}
		
		//converting wrapper class into primitives
		//can use java8 filter here
		int[] uniqueNumbers = new int[elementWithCount.keySet().size()];
		int index =0;
		for(Integer val : elementWithCount.keySet()) {//less than or equal to n times that is, n or n-c time
			uniqueNumbers[index] = val;
			index++;			
		}
		
		return uniqueNumbers;
	}

	private boolean checkElementCounted(int element, Map<Integer, Integer> elementWithCount) {
		Iterator<Integer> iterator = elementWithCount.keySet().iterator();
		while(iterator.hasNext()) {// n time
			if(element == iterator.next()) {
				return true;
			}			
		}
		
		return false;
	}

	public boolean isDuplicated(int[] randomNumbers, int generatedNumber, int indexToCheck) {
		
		for(int index=0; index < indexToCheck; index++) {
			if(randomNumbers[index] == generatedNumber) {
				return true;
			}
		}
		
		return false;
	}
	
	//This method removed defaulted/padded '0' at the end of the array 'randomNumbers'
	public int[] removeDefaultValues(int[] randomNumbers, int[] nonDuplicatedNumbers) {
			
			//Checks whether the last element in array 'randomNumbers' is default value 0. If so, array has some defaulted values
			//and need to be cleaned up
			if(randomNumbers[randomNumbers.length-1] == 0) {//for best case array has no default value 0 at the end
				
				// Worst case n-1 times. one element got duplicated, so it has to copy all the n-1 elements
				for(int index = 0; index <nonDuplicatedNumbers.length; index++) {
					nonDuplicatedNumbers[index] = randomNumbers[index];
				}
				return nonDuplicatedNumbers;
			}else {
				return randomNumbers;
			}
		}

}

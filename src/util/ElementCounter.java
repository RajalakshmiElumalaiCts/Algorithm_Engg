package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ElementCounter {

	public void countElemnet(int[] randomNumbers, Map<Integer, Integer> elementCountMap) {
		for(int element : randomNumbers) {// n time
			Integer countValue = elementCountMap.get(element);
			if(countValue != null) {
				//Element already exists, just increase the count
				countValue++;
				elementCountMap.put(element,countValue);
				
			}else {
				//first occurrence recorded
				elementCountMap.put(element,1);
			}
			
		}
		
	}

	public Map<Integer, String> calculateElementProbability(int totalElemnetCount, Map<Integer, Integer> elementCountMap) {
		
		Iterator<Entry<Integer, Integer>> iterator = elementCountMap.entrySet().iterator();
		Map<Integer, String> elementProbabilityMap = new HashMap<Integer, String>();
		
		//formats the divided value for 3 decimal places
	      DecimalFormat df = new DecimalFormat("#.####");
	      df.setRoundingMode(RoundingMode.CEILING);
		
		Entry<Integer, Integer> entry;
		String elementProbability;
		while(iterator.hasNext()) {// n time
			entry = iterator.next();			
		      
		  	//calculates p{x} = n{x} / totalElemnetCount
			elementProbability = df.format((float)entry.getValue() / totalElemnetCount);
			elementProbabilityMap.put(entry.getKey(), elementProbability);
		}
		
		return elementProbabilityMap;
	}

}

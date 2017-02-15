package com.jones.maxsatisfaction.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateMaxSatisfaction {
	
	@Autowired
	ReadData readData;
	
	public int findMaxSatisfaction(int timeLimit) throws IOException {
		Map<Integer,Integer> data=readData.readFile();
		Optional<Entry<Integer, Integer>> maxData=data.entrySet().stream()
		.filter(p -> p.getValue().intValue() <= timeLimit)
		.max((i,j)-> i.getKey().intValue()-j.getKey().intValue());
		if (maxData.isPresent()) 
			return maxData.get().getKey();
		return 0;
		
		
	}

}

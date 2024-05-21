/*
 * Copyright (c) 2013-2017 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.jarscan.allocationcount;

import static org.adoptopenjdk.jitwatch.core.JITWatchConstants.C_COMMA;
import static org.adoptopenjdk.jitwatch.core.JITWatchConstants.C_DOUBLE_QUOTE;
import static org.adoptopenjdk.jitwatch.core.JITWatchConstants.S_NEWLINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.adoptopenjdk.jitwatch.model.bytecode.Opcode;

public class AllocCountMap
{
	private Map<String, Integer> typeCountMap = new TreeMap<>();
	
	public void countAllocationOfType(String type)
	{
		Integer count = typeCountMap.get(type);
		
		if (count == null)
		{
			count = 1;
		}
		else
		{
			count++;
		}
		
		typeCountMap.put(type, count);
	}
	
	public String toString(Opcode prefix, int limitPerInvoke)
	{
		StringBuilder builder = new StringBuilder();
		
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(typeCountMap.entrySet());

		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		int outputCount = 0;

		for (Map.Entry<String, Integer> entry : sortedList)
		{
			String methodName = entry.getKey();
			Integer count = entry.getValue();
			
			builder.append(C_DOUBLE_QUOTE).append(prefix.getMnemonic()).append(C_DOUBLE_QUOTE).append(C_COMMA);
			builder.append(C_DOUBLE_QUOTE).append(methodName).append(C_DOUBLE_QUOTE).append(C_COMMA);
			builder.append(count).append(S_NEWLINE);
			
			outputCount++;;
			
			if (limitPerInvoke != 0 && outputCount == limitPerInvoke)
			{
				break;
			}
		}
				
		return builder.toString();
	}
}
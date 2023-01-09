package com.iitm.raj.hello;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordListCreater {

public static Map<String, Set<String>> wrdListForAbbr(){
	
	CamelExplicitSplitter.wrdSplit.values().removeIf(Set::isEmpty);
	Set<String> seet = CamelExplicitSplitter.wrdSplit.keySet();
	Collection<Set<String>> abrSet = CamelExplicitSplitter.wrdSplit.values();
	Map<String,Set<String>> dictListForAbbr = new HashMap<String, Set<String>>();
	for (String abrId : seet) {
		
		//System.out.println(abrId);
		
		Set<String> realWrdForAbrSet = new HashSet<String>();
			for (String abr : CamelExplicitSplitter.wrdSplit.get(abrId)) {
				//System.out.println(abr);
					if (abr.length() >= 2) {
					//System.out.println(abr);
					Set<String> srdLstForAbbr = JSONParserForAbbreviation.wordForAbbreviation(abr);
					//System.out.println(srdLstForAbbr);
					realWrdForAbrSet.addAll(srdLstForAbbr);
					srdLstForAbbr.clear();
				}
				
				
			}
		dictListForAbbr.put(abrId, realWrdForAbrSet);
	}
	
	return dictListForAbbr;
	
}

public static void main(String[] args) {
	CamelExplicitSplitter.idfyIdentifiers("E:\\raaaj\\src\\raj\\BubbleSortExample.java");
	Map<String, Set<String>> wlf = wrdListForAbbr();
	System.out.println(wlf);
}
}

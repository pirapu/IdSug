package com.iitm.raj.hello;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
public static void main(String[] args) throws IOException {
	String message2 = "";
	CamelExplicitSplitter.idfyIdentifiers("E:\\raaaj\\src\\raj\\BubbleSortExample.java");
	Map<String, Set<String>> wlf = null;
	Set set2 = wlf.entrySet();
	Iterator itr2 = set2.iterator();
	while (itr2.hasNext()) { // Converting to Map.Entry //so that we can get key and value separately

		@SuppressWarnings("rawtypes")
		Map.Entry entry = (Map.Entry) itr2.next();
		//System.out.println(entry.getKey() + " " + entry.getValue());
		message2 = message2+ entry.getKey() + " " + entry.getValue() + "       ";
		
	}
	System.out.println(message2);
}
}

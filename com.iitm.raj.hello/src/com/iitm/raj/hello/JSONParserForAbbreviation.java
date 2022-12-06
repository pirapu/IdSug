package com.iitm.raj.hello;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;

public class JSONParserForAbbreviation {
	
	static Set<String> wrdForAbbr = new HashSet<String>();
	
	@SuppressWarnings("rawtypes")
	public static void wordForAbbreviation(String str) {
		
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader("E:\\eclipse\\com.iitm.raj.hello\\Data\\abbr.json"));
	       JSONObject jsonObj = (JSONObject)obj;
	       JSONArray jsonArr = (JSONArray) jsonObj.get("abbreviations");
	       for (Object object : jsonArr.toArray()) {
	    	    //System.out.println( ((HashMap) object).get("abbr")+ " - " +  ((HashMap) object).get("desc"));
	    	   	if(((HashMap) object).get("abbr").toString().equalsIgnoreCase(str)) {
	    	   		wrdForAbbr.add(((HashMap) object).get("desc").toString());
	    	   	}
	       }
	    } catch(Exception e) {
	        e.printStackTrace();
	     }
		
	}
	
	public static void main(String[] args) {
		wordForAbbreviation("str");
		for(String descWrd : wrdForAbbr) {
			System.out.println(descWrd);
		}
	}
}

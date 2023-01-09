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
	
	//getting all the full words for abbreviation from the JSON file
	@SuppressWarnings("rawtypes")
	public static Set<String> wordForAbbreviation(String str) {
		
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader("E:\\eclipse\\com.iitm.raj.hello\\Data\\abbr.json"));
	       JSONObject jsonObj = (JSONObject)obj;
	       JSONArray jsonArr = (JSONArray) jsonObj.get("abbreviations");
	       for (Object object : jsonArr.toArray()) {
	    	    //System.out.println("Raaaaj"+ ((HashMap) object).get("abbr").toString().equalsIgnoreCase(str));
	    	   	if(((HashMap) object).get("abbr").toString().equalsIgnoreCase(str)) {
	    	   		wrdForAbbr.add(((HashMap) object).get("desc").toString());
	    	   	}
	       }
	    } catch(Exception e) {
	        e.printStackTrace();
	     }
		return wrdForAbbr;
		
	}
	
	//check whether the abbr is available or not 
	@SuppressWarnings("rawtypes")
	public static boolean isAbbr(String str) {
		
		boolean isThere = false;
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader("E:\\eclipse\\com.iitm.raj.hello\\Data\\abbr.json"));
	       JSONObject jsonObj = (JSONObject)obj;
	       JSONArray jsonArr = (JSONArray) jsonObj.get("abbreviations");
	       for (Object object : jsonArr.toArray()) {
	    	   // System.out.println("Raaaaj"+ ((HashMap) object).get("abbr").toString().equalsIgnoreCase(str));
	    	   	if(((HashMap) object).get("abbr").toString().equalsIgnoreCase(str)) {
	    	   		isThere = true;
	    	   		return isThere;
	    	   	}
	    	   	
	       }
	    } catch(Exception e) {
	        e.printStackTrace();
	     }
		return isThere;
	}
	
	public static void main(String[] args) {
		
		  boolean is = isAbbr("arr"); 
		  //System.out.println(is);
		 
		Set<String> srdLstForAbbr = wordForAbbreviation("str");
		for(String descWrd : srdLstForAbbr) {
			System.out.println(descWrd);
		}
	}
}

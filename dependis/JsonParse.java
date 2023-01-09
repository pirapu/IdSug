package Similarity;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParse {
	static Set<String> comments = new HashSet<String>();
	public static void codeGrabber(String jsnPath, String jvaPath) {
		
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader(jsnPath));
	       JSONObject jsonObj = (JSONObject)obj;
	       JSONArray jsonArr = (JSONArray) jsonObj.get("codComents");
	       for (Object object : jsonArr.toArray()) {
	    	   double smlty =  ASTSimilarity.similarityCheck(jvaPath,((HashMap) object).get("code").toString());
	    	   if(smlty>70) {
	    		   comments.add(((HashMap) object).get("nl").toString());
	    	   }
	       }
	    } catch(Exception e) {
	        e.printStackTrace();
	     }
		
	}
	public static void main(String[] args) {
		codeGrabber("F:\\data\\data\\train1.json", "F:\\MOSS\\base\\FibonacciExample1.java");
		for(String comment : comments) {
			
			System.out.println(comment);
		}
	}
}

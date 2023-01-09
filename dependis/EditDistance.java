package spellChecking;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EditDistance {
	
	    static int min(int x, int y, int z)
	    {
	        if (x <= y && x <= z)
	            return x;
	        if (y <= x && y <= z)
	            return y;
	        else
	            return z;
	    }
	 
	    static int editDist(String str1, String str2, int m,
	                        int n)
	    {
	        
	        if (m == 0)
	            return n;
	        if (n == 0)
	            return m;
	 
	        // If last characters of two strings are same,
	        // nothing much to do. Ignore last characters and
	        // get count for remaining strings.
	        if (str1.charAt(m - 1) == str2.charAt(n - 1))
	            return editDist(str1, str2, m - 1, n - 1);
	 
	        // If last characters are not same, consider all
	        // three operations on last character of first
	        // string, recursively compute minimum cost for all
	        // three operations and take minimum of three
	        // values.
	        return 1
	            + min(editDist(str1, str2, m, n - 1), // Insert
	                  editDist(str1, str2, m - 1, n), // Remove
	                  editDist(str1, str2, m - 1,
	                           n - 1) // Replace
	              );
	    }
	 
	    // Driver Code
	    public static void main(String args[]) throws IOException
	    {
	    	NGram ng = new NGram();
	    	Set<String> sugWrdList = new HashSet<>();
	  	  	Set<String> grams = (Set<String>) ng.getGrams("wrd", 2);
	  	  	Map<String, Set<String>> pstList = ng.postList("wrd", 2);
	  		for(String key : pstList.keySet()) {
	  			Set<String> values = (Set<String>) pstList.get(key);
	  			for(String value : values) {
	  				int eDistance = editDist("wed", value, "wrd".length(), value.length());
	  				if(eDistance<=5) {
	  					sugWrdList.add(value);
	  				}
	  			}
	    	
	    	
	    }
	  		for(String strSug : sugWrdList) {
				System.out.println(strSug);
			}
	}
}


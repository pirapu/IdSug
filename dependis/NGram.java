package spellChecking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NGram {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		Map<String, List<String>> pstList = postList("word", 2);
		Set set=pstList.entrySet();//Converting to Set so that we can traverse  
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        //Converting to Map.Entry so that we can get key and value separately  
	    	Map.Entry entry=(Map.Entry)itr.next();  
	        System.out.println(entry.getKey()+" "+entry.getValue());  
	    }  
	}

	//Generating n-grams
	private static List<String> getGrams(String word, int k) {
		List<String> kGrams = new ArrayList<String>();
		for (int wordIndex = 0; wordIndex < word.length() - k + 1; wordIndex++) {
			kGrams.add(word.substring(wordIndex, wordIndex + k));
		}
		return kGrams;
	}
	
	//Making posting lists for all ngarms
	public static Map<String, List<String>> postList(String word, int k) throws IOException{
		Map<String, List<String>> postingList = new HashMap<String, List<String>>();
		List<String> getGrams = getGrams(word, k);
		
		for(String eachGram: getGrams) {
			List<String> lstPstLst =  genList(eachGram);
			//System.out.println(eachGram); 	  
            postingList.put(eachGram, lstPstLst);
		}
		
		return postingList;
	}
	
	
	//Generating list for posting list
	public static List<String> genList(String nGrams) throws IOException{
		File path = new File(Settings.getSpellTestPath());
		FileInputStream fis= new FileInputStream(new File(path.toString()));
    	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str = br.readLine();
        
        List<String>  lstPstLst = new ArrayList<String>();
        while ((str = br.readLine()) != null) {
            if (str.contains(nGrams)) {
               lstPstLst.add(str);
            }
        }
        br.close();
		
		return lstPstLst;
	}
}
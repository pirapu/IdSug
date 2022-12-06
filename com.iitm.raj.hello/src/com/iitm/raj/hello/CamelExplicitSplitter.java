package com.iitm.raj.hello;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CamelExplicitSplitter {

	
	static Map<String, Set<String>> wordList = new HashMap<String, Set<String>>();
	static Map<String, Set<String>> wrdUnsplit = new HashMap<String, Set<String>>();
	static Map<String, Set<String>> wrdSplit = new HashMap<String, Set<String>>();

	@SuppressWarnings({ "static-access" })
	public static void idfyIdentifiers(String path) {

		// parsing java file into ast parser
		ASTReader ast = new ASTReader();
		try {
			Set<String> names1 = ast.parse(ast.readFileToString(path));
			for (String identifiers : names1) {
				StringBuilder identifier = new StringBuilder(identifiers);
				// System.out.println(identifiers);

				// StringBuilder str2 = new StringBuilder();
				// checking whether the extracted identifiers are dictionary word or not
				DictWordChecker dctWrdChk = new DictWordChecker();
				if (dctWrdChk.check_for_word(identifier) == true) {
					Set<String> dictWord1 = new HashSet<String>();
					dictWord1.add(identifiers);
					wordList.put(identifiers, dictWord1);
				} else if (identifiers.matches(".*[A-Z0-9_$].*")) {

					// split the composed identifiers
					Set<String> splitNames = new HashSet<String>();
					Set<String> dictWord2 = new HashSet<String>();
					for (String wd : identifiers.split("(?=[A-Z0-9_$])")) {
						//System.out.println(wd);
						
						String wd1 = wd.replaceAll("[0-9_$]", "").toLowerCase();
						
						StringBuilder wrd = new StringBuilder(wd1);
						//System.out.println(wd1);
						if (wd1.length() >= 2 && dctWrdChk.check_for_word(wrd) == true) {
							
							//System.out.println(wd1);
							dictWord2.add(wd1);
							
						} else {
							splitNames.add(wd);
						}
					}
					wordList.put(identifiers, dictWord2);
					wrdSplit.put(identifiers, splitNames);
					// splitNames.clear();
				} else {
					Set<String> unSplitNames = new HashSet<String>();
					unSplitNames.add(identifiers);
					wrdUnsplit.put(identifiers, unSplitNames);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		idfyIdentifiers("E:\\raaaj\\src\\raj\\BubbleSortExample.java");

		@SuppressWarnings("rawtypes")
		Set set = wrdUnsplit.entrySet();// Converting to Set so that we can traverse

		@SuppressWarnings("rawtypes")
		Iterator itr = set.iterator();
		while (itr.hasNext()) { // Converting to Map.Entry //so that we can get key and value separately

			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

		/*
		 * for(String s : splitNames) { System.out.println(s); }
		 */

	}
}
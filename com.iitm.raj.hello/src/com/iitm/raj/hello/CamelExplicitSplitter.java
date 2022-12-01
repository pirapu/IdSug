package com.iitm.raj.hello;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CamelExplicitSplitter {
	static Set<String> splitNames = new HashSet<String>();
	static Set<String> unSplitNames = new HashSet<String>();
	static Set<String> dictWord = new HashSet<String>();

	@SuppressWarnings({ "static-access" })
	public static void idfyIdentifiers(String path) {
		//parsing java file into ast parser
		ASTReader ast = new ASTReader();
		try {
			Set<String> names1 = ast.parse(ast.readFileToString(path));
			for (String identifiers : names1) {
				// System.out.println(identifiers);

				//checking whether the extracted identifiers are dictionary word or not
				DictWordChecker dctWrdChk = new DictWordChecker();
				if(dctWrdChk.check_for_word(identifiers) == true) {
					dictWord.add(identifiers);
				}
				
				String str2 = "";
				String str3 = "";
				for (String wd : identifiers.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
					if (identifiers == wd) {
						str2 = wd;
					} else
						splitNames.add(wd);
					// System.out.println(w);
				}
				//split at $ sign
				if (str2.contains("$")) {
					String st1[] = str2.split("\\$");
					for (String s1 : st1) {
						// System.out.println(s1);
						splitNames.add(s1);
					}
				} else {
					//split at numbers/underscore
					String str = "_1234567890";
					for (int i = 0; i < str.length(); i++) {
						if (str2.contains(str.charAt(i) + "")) {

							String st2[] = str2.split(str.charAt(i) + "");
							for (String s2 : st2) {
								// System.out.println(s2);
								splitNames.add(s2);
							}
							str2 = " ";
						}
					}
					str3 = str3 + str2;
				}
				// System.out.println(str3);
				unSplitNames.add(str3);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		idfyIdentifiers("E:\\raaaj\\src\\raj\\BubbleSortExample.java");
		for (String k : unSplitNames) {
			System.out.println(k);
		}
	}
}
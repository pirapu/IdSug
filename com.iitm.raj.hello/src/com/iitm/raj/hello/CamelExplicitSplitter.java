package com.iitm.raj.hello;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CamelExplicitSplitter {
	static Set<String> splitNames = new HashSet<String>();
	static Set<String> unSplitNames = new HashSet<String>();

	@SuppressWarnings({ "static-access" })
	public static void idfyIdentifiers(String path) {
		ASTReader ast = new ASTReader();
		try {
			Set<String> names1 = ast.parse(ast.readFileToString(path));
			for (String identifiers : names1) {
				// System.out.println(identifiers);

				String str2 = "";
				for (String wd : identifiers.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
					if (identifiers == wd) {
						str2 = wd;
					} else
						splitNames.add(wd);
					// System.out.println(w);
				}

				if (str2.contains("$")) {
					String st1[] = str2.split("\\$");
					for (String s1 : st1) {
						//System.out.println(s1);
						splitNames.add(s1);

					}
				} else if(!str2.contains("$")){

					String str = "_1234567890";
					for (int i = 0; i < str.length(); i++) {
						if (str2.contains(str.charAt(i)+"")) {
							String st2[] = str2.split(str.charAt(i)+"");
							for (String s2 : st2) {
								// System.out.println(s1);
								splitNames.add(s2);

							}

						} 
					}
				}else {
					unSplitNames.add(str2);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		idfyIdentifiers("E:\\raaaj\\src\\raj\\BubbleSortExample.java");
		for (String k : unSplitNames) {
			//System.out.println(k);
		}
	}
}
package com.iitm.raj.hello;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.ecf.core.util.StringUtils;




public class CamelExplicitSplitter {
	static Set<String> splitNames = new HashSet<String>();
	static Set<String> unSplitNames = new HashSet<String>();
	
	
	@SuppressWarnings({ "static-access", "null" })
	public static void idfyIdentifiers(String path)
	{
		ASTReader ast = new ASTReader();
		try {
			Set<String> names1 =	ast. parse(ast.readFileToString(path));
			for(String identifiers:names1){
				 //System.out.println(identifiers);
			 
		
		String str2="";
	    for (String w : identifiers.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	    	if (identifiers==w){
	    		str2=w;
	    	}
	    	else
	    		splitNames.add(w);
	       // System.out.println(w);
	    }
	    String str[]  = {"_","-","1","2","3","4","5","6","7","8","9","0"};
		for (String s:str){
			if (str2.contains(s)){
				String[] st1 = null;
				@SuppressWarnings("unused")
				String st[]=StringUtils.split(str2, s, 0);
				for (String s1: st1){
					//System.out.println(s1);
		    		splitNames.add(s1);

				}
			}else
				unSplitNames.add(str2);
		}
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		idfyIdentifiers("E:\\runtime-EclipseApplication\\raaaj\\src\\raj\\BubbleSortExample.java");
		for(String k:splitNames){
			//System.out.println(k);
		}
	}
}
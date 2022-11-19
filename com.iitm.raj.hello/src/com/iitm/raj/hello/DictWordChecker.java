package com.iitm.raj.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class DictWordChecker {
	
	
	
    public static boolean check_for_word(String word) {
    	
        try {
        	FileInputStream fis= new FileInputStream(new File("E:\\eclipse\\com.iitm.raj.hello\\Data\\words_alpha.txt"));
        	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            
            String str;
            
            while ((str = br.readLine()) != null) {
                if (str.equalsIgnoreCase(word)) {
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(check_for_word("str"));
        
		}
    }

package com.iitm.raj.hello;

import java.util.ArrayList;
 

 
/** class TernarySearchTree **/
class TernarySearchTree
{
    private TSTNode root;
    private ArrayList<String> al;
 
    /** Constructor **/
    public TernarySearchTree()
    {
        root = null;
    }
    
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return root == null;
    }
    
    
    /** function to insert for a word **/
    public void insert(StringBuilder word)
    {
    	char[] array = new char[word.length()];
		word.getChars(0, word.length(), array, 0);
        root = insert(root, array, 0);
    }
    
    /** function to insert for a word **/
    public TSTNode insert(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            r = new TSTNode(word[ptr]);
 
        if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr);
        else if (word[ptr] > r.data)
            r.right = insert(r.right, word, ptr);
        else
        {
            if (ptr + 1 < word.length)
                r.middle = insert(r.middle, word, ptr + 1);
            else
                r.isEnd = true;
        }
        return r;
    }
 
    
    /** function to search for a word **/
    public boolean search(StringBuilder word)
    {	
    	char[] array = new char[word.length()];
		word.getChars(0, word.length(), array, 0);
        return search(root, array, 0);
    }
    /** function to search for a word **/
    private boolean search(TSTNode r, char[] word, int ptr)
    {
        if (r == null)
            return false;
 
        if (word[ptr] < r.data)
            return search(r.left, word, ptr);
        else if (word[ptr] > r.data)
            return search(r.right, word, ptr);
        else
        {
            if (r.isEnd && ptr == word.length - 1)
                return true;
            else if (ptr == word.length - 1)
                return false;
            else
                return search(r.middle, word, ptr + 1);
        }        
    }
    
    
    /** function to print tree **/
    public String toString()
    {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : "+ al;
    }
    
    /** function to traverse tree **/
    private void traverse(TSTNode r, String str)
    {
        if (r != null)
        {
            traverse(r.left, str);
 
            str = str + r.data;
            if (r.isEnd)
                al.add(str);
 
            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);
 
            traverse(r.right, str);
        }
    }
}
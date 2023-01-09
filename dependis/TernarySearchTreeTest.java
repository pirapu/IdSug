package spellChecking;

import java.util.Scanner;

public class TernarySearchTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        /* Creating object of TernarySearchTree */
        TernarySearchTree tst = new TernarySearchTree(); 
        
               System.out.println("Enter word to insert");
               tst.insert( scan.next() );                     
                
            System.out.println(tst);
            scan.close();     
    }
}

package spellChecking;
import java.util.*;


class JaccardCoeficient
{
 
  // Function to return the intersection set of s1 and s2
  static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2)
  {
 
    // Find the intersection of the two sets
    HashSet<Integer> intersect = new HashSet<Integer>();
    for (int elem : set1)
    {
      if (set2.contains(elem))
        intersect.add(elem);
    }
 
    return intersect;
  }
 
  // Function to return the Jaccard index of two sets
  static double jaccard_index(HashSet<Integer> set1, HashSet<Integer> set2)
  {
    // Sizes of both the sets
    int size_s1 = set1.size();
    int size_s2 = set2.size();
 
    // Get the intersection set
    HashSet<Integer> intersect = intersection(set1, set2);
 
    // Size of the intersection set
    int size_in = intersect.size();
 
    // Calculate the Jaccard index
    // using the formula
    double jaccard_in  = (double)size_in / (double)(size_s1 + size_s2 - size_in);
 
    // Return the Jaccard index
    return jaccard_in;
  }
 
  public static void main(String[] args)
  {
    HashSet<Integer> s1 = new HashSet<Integer>();
    s1.add(1);
    s1.add(2);
    s1.add(3);
    s1.add(4);
    s1.add(5);
 
    // Elements of the 2nd set
    HashSet<Integer> s2 = new HashSet<Integer>();
    s2.add(4);
    s2.add(5);
    s2.add(6);
    s2.add(7);
    s2.add(8);
    s2.add(9);
    s2.add(10);
 
    double jaccardIndex = jaccard_index(s1, s2);
 
    // Print the Jaccard index and Jaccard distance
    System.out.println("Jaccard index = " + jaccardIndex);
    
  }
}
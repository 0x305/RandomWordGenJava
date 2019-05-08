
package pronounceable_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * 
 */
public class Units {
    
    char[] vowels = new char[]{'a','e','i','o','u'};
    public static ArrayList<UnitPairRules> unitPairs = new ArrayList<UnitPairRules>();
   
    
    //scan each line from fiile for strings. then assign each to name of indexed in array list.
    //then scan for each boolean and assign each index the corresponding boolean
    
    //once you set it up, then the random generator will check if it contains any of the combos by checking each
    //index. If it does, you make identical booleans to be set equal to the indexed booleans.
    //Then there will be a method for each modification 
    
    public void scanUnitPair()throws FileNotFoundException {
        
        
        File pairFile = new File ("UnitPairRules.txt"); 
        String encoding = "Cp1250"; //need to do this to make it ASCII
        
        
        //Declaring all the features of a unit pair that will be plugged into the list
        String combo;
        Boolean mustBegin = false;
        Boolean mustNotBegin = false;
        Boolean needsBreak = false;
        Boolean needsVowelPrefix = false;
        Boolean mustEnd= false;
        Boolean mustNotEnd= false;
       
        if (pairFile.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pairFile), encoding))) {
            String line = br.readLine();
        
            while ((line != null)) {
              
                combo = line.replaceAll("[^A-Za-z]+", "");
               
               if (line.charAt(0)=='1'){
                   mustBegin = true;
               }
               else{
                   mustBegin = false;
               }
               if(line.charAt(1)=='1'){
                   mustNotBegin = true;
               }
               else{
                   mustNotBegin = false;
               }
               if(line.charAt(2)=='1'){
                   needsBreak = true;
               }
               else{
                   needsBreak = false;
               }
               if(line.charAt(3) =='-'){
                   needsVowelPrefix = true;
               }
               else{
                   needsVowelPrefix = false;
               }
               
               if(line.charAt(13)=='1'){//the whitespace in the txt file counts as char
                   mustEnd = true;
               }
               else{
                   mustEnd = false;
               }
               if(line.charAt(14)=='1'){
                   mustNotEnd = true;
               }
               else{
                   mustNotEnd = false;
               }
               //Now creating new object of unit pair with corresponding features
              UnitPairRules newSet = new UnitPairRules(combo,mustBegin,mustNotBegin,needsBreak,needsVowelPrefix,
                                                        mustEnd,mustNotEnd);
              //plugging that object into the array list
              unitPairs.add(newSet);
              //moving to next line
              line = br.readLine();
            
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
else {
    System.out.println("file doesn't exist");
}
        
    }
    
    }
  



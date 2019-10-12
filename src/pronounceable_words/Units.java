
package pronounceable_words;

import java.io.File;
import java.util.HashMap;
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
    
    
    HashMap<String, UnitPairRules> unitPairs = new HashMap<>();
   
  
    public void scanUnitPair()throws FileNotFoundException {
        
        
        File pairFile = new File ("UnitPairRules.txt"); 
        String encoding = "Cp1250"; //need to do this to make it ASCII
        
        if (pairFile.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pairFile), encoding))) {
            String line = br.readLine();
        
            while ((line != null)) {
                
                Boolean mustBegin = false;
                Boolean mustNotBegin = false;
                Boolean needsBreak = false;
                Boolean needsVowelPrefix = false;
                Boolean mustEnd= false;
                Boolean mustNotEnd= false;
                String combo = line.replaceAll("[^A-Za-z]+", "");
               
               if (line.charAt(0)=='1'){
                   mustBegin = true;
               }
              
               if(line.charAt(1)=='1'){
                   mustNotBegin = true;
               }
               
               if(line.charAt(2)=='1'){
                   needsBreak = true;
               }
               
               if(line.charAt(3) =='-'){
                   needsVowelPrefix = true;
               }
               
               if(line.charAt(13)=='1'){//the whitespace in the txt file counts as char
                   mustEnd = true;
               }
               
               if(line.charAt(14)=='1'){
                   mustNotEnd = true;
               }
               
               
              UnitPairRules newSet = new UnitPairRules(mustBegin,mustNotBegin,needsBreak,needsVowelPrefix,
                                                        mustEnd,mustNotEnd);
              
              unitPairs.put(combo, newSet);
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
  



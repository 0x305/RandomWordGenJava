/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/**
 *
 * 
 */
public class Syllables {
    
    File syllables = new File("Syllables (15,831 Verbal).txt");
    
    String encoding = "Cp1250";
    
    
    HashSet<String> syllable = new HashSet<>();
    
    public void scanSyllables() throws FileNotFoundException{
       
        if (syllables.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(syllables), encoding))) {
            String line = br.readLine();
            
            while ((line != null)) {
                
                syllable.add(line);
                line = br.readLine();
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
        }
        
    }
    
    public Boolean beforeSyllable(String word)throws FileNotFoundException{
        
        for(String syll: syllable){
            if(word.endsWith(syll)){
                return true;
            }
        }
               
        return false;
    }
    
    public Boolean afterSyllable(String word)throws FileNotFoundException{
        
        for(String syll: syllable){
            
            if(word.indexOf(syll)==0){
               return true;
           }
        }
        return false;
    }
}

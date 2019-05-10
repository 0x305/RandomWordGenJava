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
import java.util.ArrayList;
/**
 *
 * 
 */
public class Syllables {
    
    File syllables = new File("Syllables (15,831 Verbal).txt");
    
    String encoding = "Cp1250";
    String syllable;
    
    public Boolean scanSyllables(String word) throws FileNotFoundException{
        
        Boolean isSyllable = false;
       
        if (syllables.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(syllables), encoding))) {
            String line = br.readLine();
            
            while ((line != null)) {
                if(word.contains(line)){
                    isSyllable = true;
                    
                }
                line = br.readLine();
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
        }
        
        return isSyllable;
    }
    
    public Boolean beforeSyllable(String word)throws FileNotFoundException{
        
        Boolean beforeSyllable = false;
        if(syllables.exists()){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(syllables), encoding))) {
            String line = br.readLine();
            
            while ((line != null)) {
                String syllable   = line.replaceAll("[^A-Za-z]+", "");
                
                if(word.endsWith(syllable)){
                    beforeSyllable = true;
                   
                }
                line = br.readLine();
                
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
        }
        return beforeSyllable;
    }
    
    public Boolean afterSyllable(String word)throws FileNotFoundException{
        
       Boolean afterSyllable = false;
        if(syllables.exists()){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(syllables), encoding))) {
            String line = br.readLine();
            
            while ((line != null)) {
                String syllable = line.replaceAll("[^A-Za-z]+", "");
                
                if(word.indexOf(syllable)==0){
                    afterSyllable = true;
                    
                }
                line = br.readLine();
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
        }
        return afterSyllable;
    }
}

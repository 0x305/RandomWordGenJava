/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;



public class Pronounceable_Words  {

       
    public static void main(String[] args)throws FileNotFoundException{
      //Testing stuff
         
         StringBuilder myName = new StringBuilder();
            
            myName.append("aanbxlonda");
            String test = "lon";
     int start = myName.indexOf("aanb");
      Generator generator = new Generator();
     
       
        Syllables testSyllable = new Syllables();
       Boolean testbool = generator.checkIfBreak(myName, "nd");
       String nope = "aanbleozzzz";
       if(nope.endsWith("bleo")){
           System.out.println("bro");
       }
       Boolean yet = testSyllable.afterSyllable("");
       // System.out.println(yet);
        Boolean yerr = generator.checkIfBreak(myName, "lo");
        Boolean yutt = testSyllable.beforeSyllable("xgggx");
        generator.checkWord(generator.randomWord(5));
        System.out.println(yutt);
        System.out.println(yerr);
        String azz = "zozz";
        if(nope.endsWith(azz)){
            System.out.println("yurdd");
        }
       //System.exit(0);
       String combo = "on";
    int comboStart = myName.indexOf(combo);
        int comboEnd = myName.indexOf(combo) + combo.length();
       
        String wordBefore = myName.substring(0,comboStart );
        String wordAfter = myName.substring(comboEnd, myName.length());
        System.out.println(wordAfter);
     // System.exit(0);
     
     
    
    generator.setConditions();
     StringBuilder originalWord = generator.randomWord(8);
        System.out.println("Original Word: "+ originalWord);
        StringBuilder qTest = new StringBuilder();
        qTest.append("qrttyq");
        int g = qTest.toString().indexOf('y');
        
        generator.checkWord(originalWord);
       
        System.out.println("Final Word: " + generator.finalWord.toString() );
       System.exit(0);
       
       //System.exit(0);
       String testCombos = originalWord.toString().substring(4,6);
       
        generator.checkIfBreak(originalWord, testCombos);
        System.out.println(testCombos);
     System.exit(0);
        
        
       
   
        
        
        
       
       System.exit(0);
        
         
      
       
        
        
        
    }
}

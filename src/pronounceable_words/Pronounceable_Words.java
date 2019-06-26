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
import java.io.PrintWriter;
import java.util.ArrayList;



public class Pronounceable_Words  {

       PrintWriter writer;
    public static void main(String[] args)throws FileNotFoundException{
    
      Generator generator = new Generator();
      
     
    generator.setConditions();
     
        
        PrintWriter writer = new PrintWriter("4Letter_Generated_Words(1000)v2.txt");
;

        try {
            for(int i=0; i<1000;i++){
                
            StringBuilder originalWord = generator.randomWord(4);
            generator.checkWord(originalWord);
            
                String line = generator.finalWord.toString();
                
                    writer.write(line);
                    writer.write("\n");
            }
        

            writer.close();

        } catch (FileNotFoundException ex) {
        
    }
        }
    
        
    }


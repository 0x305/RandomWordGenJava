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
/**
 *
 
 */
public class Pronounceable_Words  {

   
  
       
    public static void main(String[] args)throws FileNotFoundException{
      //Testing stuff
         
         StringBuilder myName = new StringBuilder();
            
            myName.append("aanblonda");
            String test = "tester";
     myName.replace(0,test.length() , test);
     if(test.endsWith("ter")){
        System.out.println("yerrrr");
        System.exit(0);}
        Units testscan = new Units(); 
        Generator generator = new Generator();
        generator.quicktest(myName);
        System.exit(0);
        generator.checkWord(myName);
        
        
       
       System.exit(0);
        
         
      generator.testJOption();
       
        
        
        
    }
}

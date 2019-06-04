
package pronounceable_words;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.FileNotFoundException;



public class Generator    {
      
 Units units = new Units();
 Syllables syllables = new Syllables();
 
 StringBuilder finalWord;
 
 
 Boolean beginFixed = false;
 Boolean notBeginFixed = false;
 Boolean endFixed = false;
 Boolean notEndFixed = false;
 

   /**
    * This method will create a random char and pass it when called. 
    * @return 
    */
    public char randomChar(){
       
        Random r = new Random();
        
        char c = (char)(r.nextInt(26) + 'a');
        
        return c;
        
    }
     
    /**
     * This method will use StringBuilder to create a string. This allows you to iterate
     * each char and assign a random char
     * Must use append. But when switching one that is not null, use setCharAt.
     *You can do this when changing it to pronounceable
     */
     
    public StringBuilder randomWord(int wordLength){
        
        StringBuilder word = new StringBuilder();
        
        for(int i=0; i<wordLength; i++){
        word.append(randomChar());
        
        }
        
        return word;
    }

    public void setConditions()throws FileNotFoundException{
         units.scanUnitPair();
    }
    
    
    /**
     * 
     * @param word 
     * This method will be used every time we want to check the word. We use StringBuilder in parameter
     * so we can pass the random word from the other methods that required StringBuilder.
     * Then each boolean is checked and its corresponding methods are called.
     */
    public void checkWord(StringBuilder word)throws FileNotFoundException{
        String givenWord = word.toString();
       int length = givenWord.length();
      
        for(int i=0;i<length;i++){
           
            if(givenWord.charAt(i)=='q'){
                
                if((i+1)!=length){//If Q is not the last char set next char u
                    word.setCharAt(i+1, 'u');
            }
                else{//if q is last letter,just replace it with random
                   word.setCharAt(i, randomChar());
                    
                }
            }
        }
        
        
            
        for(int i=0; i<length-4;i++){//checking if sets of two chars dont repeat consecutively
            
            if((word.charAt(i)==word.charAt(i+2))&&(word.charAt(i+1)==word.charAt(i+3))){
                
                swapConsecutiveCombo(word, i+2, i+3);
                
            }
        }
        
        
        for(int i=0; i<units.unitPairs.size();i++){
            String wordCombo = units.unitPairs.get(i).combo;
            
            if(word.toString().contains(wordCombo)){//StringBuilder doesnt have .contains() but we can use toString() to interpret it as a String first
               
                //needsBreak MUST go first. Because if word changes by the time it gets to it, combo wont be there and indexes will cause error
                //You can also change them to else if's
                if((units.unitPairs.get(i).needsBreak == true)&&(checkIfBreak(word,wordCombo)==false)){
                   modifyMustBreak(word,wordCombo);
                          
                }   
                else if((units.unitPairs.get(i).mustBegin == true)&&(beginFixed==false)){
                    
                    modifyBegin(word,wordCombo);
                    
            }
                else if((units.unitPairs.get(i).mustNotBegin==true)){
                    if(word.indexOf(wordCombo)==0){
                        modifyNotBegin(word,wordCombo);
                }
                
            }
                else if((units.unitPairs.get(i).mustEnd == true)&&(!givenWord.endsWith(wordCombo))){
                   modifyEnd(word,wordCombo); 
                }
                else if((units.unitPairs.get(i).mustNotEnd == true)&&(givenWord.endsWith(wordCombo))){
                    modifyNotEnd(word, wordCombo);
                }
                
                else{
                    finalWord = word;
                }
                
        }
     
}
    
    
    }
    /**
     * 
     * @param word
     * @param combo
     * 
     * This method takes a word and a combo. Finds which index the combo is found, and removes
     * it from the word. Then, the combo is placed into the beginning of the word.
     * We must use StringBuilder because the .delete and .insert only works with stringBuilder
     * 
     */
    public void modifyBegin(StringBuilder word, String combo)throws FileNotFoundException{
       //check if there is already a combo that is in first index
       
        StringBuilder newRandomReplace = randomWord(combo.length());
        int start = word.indexOf(combo);
        int end = start + combo.length();
        Boolean keepCombo =true;
        
        for(int i=0;i<units.unitPairs.size();i++){
            String currentCombo = units.unitPairs.get(i).combo;
            //if there is already a mustBegin combo that begins the word, the other combo will just be replaced
            //with another random string. This prevents recursion of fighting for who begins word
            if((units.unitPairs.get(i).mustBegin==true)&&(word.indexOf(currentCombo)==0)&&(currentCombo!=combo)){
                word.replace(start, end, newRandomReplace.toString());
                keepCombo=false;
            }
            
            
            if(keepCombo== true){
                word.delete(start, end);//remove where the combo was
                word.insert(0, combo);//add combo to beginning
                beginFixed = true;
            }
        }
        
        
       checkWord(word); //checking the word again
        
    }
    /**
     * 
     *
     * @param word
     * @param combo
     * 
     * This method will replace the beginning of the word with a new random combination.
     * Notice how we need to use toString to interpret the given stringBuilder as a string
     */
    public void modifyNotBegin(StringBuilder word, String combo)throws FileNotFoundException{
        
        
            StringBuilder newRandomReplace = randomWord(combo.length());
            word.replace(0, combo.length(), newRandomReplace.toString());
           
        checkWord(word);
        }
    /**
     * 
     * @param word
     * @param combo
     * 
     * This method is for the mustEnd condition. It will do the same thing as modify beginning. We have to check if there
     * is already a combo that ends the word that is required. That way it wont keep fighting each other
     */
    public void modifyEnd(StringBuilder word, String combo)throws FileNotFoundException{
        
        StringBuilder newRandomReplace = randomWord(combo.length());
        int start = word.indexOf(combo);
        int end = start + combo.length();
        Boolean keepCombo =true;
        
        for(int i=0;i<units.unitPairs.size();i++){
            String currentCombo = units.unitPairs.get(i).combo;
            String givenWord = word.toString();//Changing the stringbuilder to string so we can use function endsWith
            
            if((units.unitPairs.get(i).mustEnd==true)&&(givenWord.endsWith(currentCombo))&&(currentCombo!=combo)){
                 word.replace(start, end, newRandomReplace.toString());
                keepCombo = false;
            }
            
    }
        if(keepCombo == true){
            word.delete(start,end);
            word.append(combo);
            
        }
        checkWord(word);
    }
    
    public void modifyNotEnd(StringBuilder word, String combo)throws FileNotFoundException{
        
        StringBuilder newRandomReplace = randomWord(combo.length());
       
        int start = word.indexOf(combo);
        int end = start + combo.length();
        
        word.replace(start, end, newRandomReplace.toString());
        
        checkWord(word);
    }
    
    public Boolean checkIfBreak(StringBuilder word, String combo)throws FileNotFoundException{
       
        
        Boolean alreadyBreaks = false;
        String wordBefore="";
        String wordAfter="";
        String givenWord = word.toString();
     
        int comboStart = word.indexOf(combo);
        int comboEnd = comboStart + combo.length();
       
        if(comboStart!=0){
        
            wordBefore = word.substring(0,comboStart );
        }
        
        if(comboEnd!=givenWord.length()-1){
            wordAfter = word.substring(comboEnd, word.length());
        }
        
        Boolean syllableBefore = syllables.beforeSyllable(wordBefore);
        Boolean syllableAfter = syllables.afterSyllable(wordAfter);
        
        if((syllableBefore==true)&&(syllableAfter==true)){
            alreadyBreaks = true;
        }
       
    
        return alreadyBreaks;
    }
    
    public void modifyMustBreak(StringBuilder word, String combo)throws FileNotFoundException {
        
       StringBuilder newRandomReplace = randomWord(combo.length());
      
        int start = word.indexOf(combo);
        int end = start + combo.length();
        
        
        word.replace(start, end, newRandomReplace.toString());
        
        checkWord(word);
        
        
    }
    
    public void swapConsecutiveCombo(StringBuilder word, int start, int end)throws FileNotFoundException{
        
        
        word.setCharAt(start,randomChar());
        word.setCharAt(end, randomChar());
        
        checkWord(word);
    }

}


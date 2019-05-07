/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;


public class UnitPairRules {
    String combo;
    Boolean mustBegin;
    Boolean mustNotBegin;
    Boolean needsBreak;
    Boolean needsVowelPrefix;
    Boolean mustEnd;
    Boolean mustNotEnd;
    
    UnitPairRules(String combo, Boolean mustBegin, Boolean mustNotBegin, Boolean needsBreak,
                  Boolean needsVowelPrefix, Boolean mustEnd, Boolean mustNotEnd){
        this.combo = combo;
        this.mustBegin= mustBegin;
        this.mustNotBegin = mustNotBegin;
        this.needsBreak = needsBreak;
        this.needsVowelPrefix = needsVowelPrefix;
        this.mustEnd = mustEnd;
        this.mustNotEnd = mustNotEnd;
    }
   
    public void setCombo(){
        this.combo = combo;
    }
    public String getCombo(){
        return combo;
    }
    
    public void setMustBegin(){
        this.mustBegin = mustBegin;
    }
    public Boolean getMustBegin(){
        return mustBegin;
    }
    public void setMustNotBegin(){
        this.mustBegin = mustBegin;
    }
    public Boolean getMustNotBegin(){
       return mustNotBegin;
    }
    public void setNeedsBreak(){
        this.needsBreak = needsBreak;
    }
    public Boolean getNeedsBreak(){
        return needsBreak;
    }
    public void setNeedsVowelPrefix(){
        this.needsVowelPrefix = needsVowelPrefix;
    }
    public Boolean getNeedsVowelPrefix(){
        return needsVowelPrefix;
    }
    public void setMustEnd(){
        this.mustEnd = mustEnd;
    }
    public Boolean getMustEnd(){
        return mustEnd;
    }
    public void setMustNotEnd(){
        this.mustNotEnd = mustNotEnd;
    }
    public Boolean getMustNotEnd(){
        return mustNotEnd;
    }
   
    
}

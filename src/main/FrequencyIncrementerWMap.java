package main;

import java.util.*;

/*
  This solution is not so good. We have just 5*10^5 words on the english vocabulary, 
  and each word has no more than 30 letters, so if the test case contains only real words 
  everything will fit in memory.
  But someone can create a test with 'fake words' to break this code.
*/

class FrequencyIncrementerWMap extends FrequencyIncrementer{
  TreeMap<String,Integer> freqMap;

  public FrequencyIncrementerWMap(){
    this.freqMap = new TreeMap<>();        
  }

  @Override
  public void incrementFrequency(String word){        
    System.out.println("asduh");
    if(freqMap.containsKey(word)){
      Integer f = freqMap.get(word);
      freqMap.replace(word,f,f+1);      
    }
    else freqMap.put(word,1);    
  }

  @Override
  public List<Frequency> getCurrFrequencies(){
    List<Frequency> wordFreq = new ArrayList<>();
    
    Set set = freqMap.entrySet();         
    Iterator i = set.iterator();     
    
    while(i.hasNext()) {      
      Map.Entry me = (Map.Entry)i.next();
      wordFreq.add(new Frequency((String)me.getKey(),(Integer)me.getValue()));      
    }    
    return wordFreq;
  }
}
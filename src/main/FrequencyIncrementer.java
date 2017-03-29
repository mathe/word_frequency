package main;

import java.util.List;

abstract class FrequencyIncrementer{ 
  
  public abstract void incrementFrequency(String word);

  public abstract List<Frequency> getCurrFrequencies();
}
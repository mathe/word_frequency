package main;

import java.util.List;

abstract class FrequencyIncrementer{
  protected static final String TEMP_DIR = "/home/matheus/Documents/materia/bd/word_frequency/temp_dir/";
  
  public abstract void incrementFrequency(String word);

  public abstract List<Frequency> getCurrFrequencies();
}
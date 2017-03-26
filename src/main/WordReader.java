package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

class WordReader{
  private final int TOTAL_NUMBER_OF_WORDS = 131072;
  
  /*
    Read more words with the s scanner, this method keeps reading more words,
    until the number of words is less than TOTAL_NUMBER_OF_CHARS.
  */
  public List<String> nextWords(Scanner s){
    String next;
    List<String> words = new ArrayList<>();    
    while(words.size() < this.TOTAL_NUMBER_OF_WORDS && s.hasNext())
      words.add(s.next());    
    return words.size() == 0 ? null : words;
  }
}
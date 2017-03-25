package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

class WordReader{
  private static final int TOTAL_NUMBER_OF_WORDS = 4096;
  
  /*
    Read more words with the s scanner, this method keeps reading more words,
    until the sum of the length of all words is less than TOTAL_NUMBER_OF_CHARS.
  */
  public static List<String> nextWords(Scanner s){
    String next;
    List<String> words = new ArrayList<>();    
    while(words.size() < this.TOTAL_NUMBER_OF_WORDS && s.hasNext())
      words.add(s.next());    
    return words.size() == 0 ? null : words;
  }
}
package main;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class WordFrequency implements FileVisitor<Path>{
  private WordReader wordReader;
  private FrequencyIncrementer freqIncrem;
  public WordFrequency(WordReader wr,FrequencyIncrementer fi){
    this.wordReader = wr;
    this.freqIncrem = fi;
  }
  
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    return FileVisitResult.CONTINUE;
  }
  
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }
  
  @Override
  public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {         
    Scanner s = new Scanner(dir.toFile()).useDelimiter("[,.;! $ \\s /]+");      
    for(List<String> words = wordReader.nextWords(s); words != null; words = wordReader.nextWords(s))
      for(String w : words)
        this.freqIncrem.incrementFrequency(w);      
    s.close();
    return FileVisitResult.CONTINUE;
  }
  
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    return FileVisitResult.CONTINUE;
  }
  
  public List<Frequency> getCurrWordFrequencies() throws IOException{
    return this.freqIncrem.getCurrFrequencies();
  }
} 
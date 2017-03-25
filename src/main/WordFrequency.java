package main;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class WordFrequency implements FileVisitor<Path>{
  private WordReader wordReader;
  
  public WordFrequency(WordReader wr){
    this.wordReader = wr;
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
      System.out.println(dir.getFileName());
      Scanner s = new Scanner(dir.toFile()).useDelimiter("[,.;! $ \\s]+");
      for(List<String> words = wordReader.nextWords(s); words != null; words = wordReader.nextWords(s)){
        for(String w : words){
          System.out.println(w);
        }
      }
      System.out.println();
      return FileVisitResult.CONTINUE;
  }
  
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
      return FileVisitResult.CONTINUE;
  }
} 
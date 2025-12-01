package com.adventofcode.day1.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {

  private static int DIAL = 50;
  private static int PWD = 0;

  public static void main(String[] args) throws FileNotFoundException {
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        lineReader(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(PWD);
  }

  private static void add(int n) {
    for (int i = 1; i <= n; i++) {
      DIAL++;
      if (DIAL == 100) {
        DIAL = 0;
        PWD++;
      }
    }
  }

  private static void sub(int n) {
    for (int i = 1; i <= n; i++) {
      DIAL--;
      if (DIAL == 0) {
        PWD++;
      } else if (DIAL < 0) {
        DIAL = 99;
      }
    }
  }

  private static void lineReader(String line) {
    if (line.startsWith("L")) {
      sub(Integer.parseInt(line.substring(1)));
    } else if (line.startsWith("R")) {
      add(Integer.parseInt(line.substring(1)));
    }
  }
}

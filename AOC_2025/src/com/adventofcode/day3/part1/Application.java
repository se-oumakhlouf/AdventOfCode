package com.adventofcode.day3.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Application {

  public static void main (String[] args) {

    List<String> lines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    long sum = 0;
    for (String line : lines) {
      List<Integer> digits = Arrays.stream(line.split("")).map(Integer::parseInt).toList();

      int maxTwoDigits = 0;
      for (int i = 0; i < digits.size(); i++) {
        for (int j = i + 1; j < digits.size(); j++) {
          int current = digits.get(i) * 10 + digits.get(j);
          if (current > maxTwoDigits) {
            maxTwoDigits = current;
          }
        }
      }
      sum += maxTwoDigits;
    }

    System.out.println(sum);
  }
}
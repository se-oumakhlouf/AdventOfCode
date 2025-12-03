package com.adventofcode.day3.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

  public static String findLargestKDigitNumber(String line, int K) {
    if (K <= 0 || K > line.length()) {
      return "";
    }

    int N = line.length();
    int digitsToRemove = N - K;

    StringBuilder stack = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int currentDigit = Character.getNumericValue(line.charAt(i));
      while (!stack.isEmpty() && digitsToRemove > 0
             && Character.getNumericValue(stack.charAt(stack.length() - 1)) < currentDigit) {

        stack.deleteCharAt(stack.length() - 1);
        digitsToRemove--;
      }
      stack.append(line.charAt(i));
    }
    if (digitsToRemove > 0) {
      stack.setLength(K);
    }

    return stack.substring(0, K);
  }

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

    int digitsRequired = 12;
    long sum = 0;

    for (String line : lines) {
      String maxKDigitNumberStr = findLargestKDigitNumber(line, digitsRequired);
      if (!maxKDigitNumberStr.isEmpty()) {
        sum += Long.parseLong(maxKDigitNumberStr);
      }
    }

    System.out.println("\nSomme totale : " + sum);
  }
}
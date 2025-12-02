package com.adventofcode.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

  public static void main (String[] args) {
    List<Long> list = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line = reader.readLine();
      String[] input = line.split(",");

      for (String s : input) {
        String[] range = s.split("-");
        long start = Long.parseLong(range[0]);
        long end = Long.parseLong(range[1]);

        for (long i = start; i <= end; i++) {
          String number = Long.toString(i);
          if (number.length() % 2 == 1) {
            continue;
          }
          int half = number.length() / 2;
          String firstHalf = number.substring(0, half);
          String secondHalf = number.substring(half);
          if (firstHalf.startsWith("0") || secondHalf.startsWith("0")) {
            continue;
          }
          if (firstHalf.equals(secondHalf)) {
            list.add(i);
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(list);
    long result = list.stream().mapToLong(Long::longValue).sum();
    System.out.println(result);
  }
}

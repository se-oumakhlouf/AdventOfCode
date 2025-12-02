package com.adventofcode.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

  public static void main (String[] args) {
    List<Long> resultList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line = reader.readLine();
      String[] input = line.split(",");

      for (String s : input) {
        String[] range = s.split("-");
        long start = Long.parseLong(range[0]);
        long end = Long.parseLong(range[1]);

        for (long i = start; i <= end; i++) {
          String number = Long.toString(i);

          boolean foundBiggestPattern = false;
          for (int nbSplits = 2; nbSplits <= number.length() && !foundBiggestPattern; nbSplits++) {
            if (number.length() % nbSplits != 0) {
              continue;
            }
            List<String> splits = new ArrayList<>();
            int splitSize = number.length() / nbSplits;
            for (int index = 0; index < nbSplits; index++) {
              splits.add(number.substring(index * splitSize, (index + 1) * splitSize ));
            }
            Set<String> set = new HashSet<>(splits);
            if (set.size() == 1) {
              resultList.add(i);
              foundBiggestPattern = true;
            }
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(resultList);
    long resultSum = resultList.stream().mapToLong(Long::longValue).sum();
    System.out.println(resultSum);
  }
}

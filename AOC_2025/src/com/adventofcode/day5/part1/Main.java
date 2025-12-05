package com.adventofcode.day5.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Parser parser = new Parser("-");
    RangeList range = new RangeList();
    List<String> lines = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    long count = 0;

    for (String line : lines) {
      if (line.isEmpty()) {
        continue;
      }
      if (parser.isRange(line)) {
        range.add(parser.parse(line));
      } else if (range.contains(Long.parseLong(line))) {
        count++;
      }
    }

    System.out.println(count);

  }
}

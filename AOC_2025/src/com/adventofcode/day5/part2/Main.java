package com.adventofcode.day5.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Parser parser = new Parser("-");
    Storage storage = new Storage();
    List<String> lines = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    for (String line : lines) {
      if (parser.isRange(line)) {
        storage.add(parser.parse(line));
      }
    }

    System.out.println(storage.countFreshIdsFromRange());

  }
}

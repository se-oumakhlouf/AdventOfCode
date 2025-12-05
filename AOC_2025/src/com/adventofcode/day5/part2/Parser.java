package com.adventofcode.day5.part2;

import java.util.Arrays;

public record Parser(String separator) {

  public Tuple parse (String line) {
    var splits = Arrays.stream(line.split(separator)).map(Long::parseLong).toList();
    return new Tuple(splits.get(0), splits.get(1));
  }

  public boolean isRange (String line) {
    return !line.isEmpty() && line.contains(separator);
  }

}

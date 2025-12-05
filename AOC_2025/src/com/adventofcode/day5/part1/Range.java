package com.adventofcode.day5.part1;

public record Range(long start, long end) {

  public boolean contains(long value) {
    return start <= value && value <= end;
  }

}

package com.adventofcode.day5.part2;

public record Range(long start, long end) {

  public boolean contains(long value) {
    return start <= value && value < end;
  }

  public boolean contains(long start, long end) {
    return contains(start) && contains(end);
  }

  public boolean contains(Range range) {
    return contains(range.start) && contains(range.end);
  }

  public long size() {
    return end - start;
  }

}

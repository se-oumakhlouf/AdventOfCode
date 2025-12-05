package com.adventofcode.day5.part1;

import java.util.ArrayList;
import java.util.List;

public class RangeList {

  private final List<Range> rangeList = new ArrayList<>();

  public void add (Tuple tuple) {
    rangeList.add(new Range(tuple.x(),  tuple.y()));
  }

  public boolean contains(Long id) {
    return rangeList.stream().anyMatch(range -> range.contains(id));
  }
}

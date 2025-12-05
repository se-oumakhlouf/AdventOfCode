package com.adventofcode.day5.part2;

import java.util.ArrayList;
import java.util.List;

public class Storage {

  private final List<Range> rangeList = new ArrayList<>();

  public void add (Tuple tuple) {
    rangeList.add(new Range(tuple.x(), tuple.y() + 1));
  }

  public long countFreshIdsFromRange () {
    List<Long> limitsIds = new ArrayList<>();
    for (Range range : rangeList) {
      limitsIds.add(range.start());
      limitsIds.add(range.end());
    }

    limitsIds.sort(Long::compareTo);

    List<Range> union = new ArrayList<>();
    for (int index = 0; index < limitsIds.size() - 1; index++) {
      Range newRange = new Range(limitsIds.get(index), limitsIds.get(index + 1));
      boolean start = false;
      boolean end = false;
      for (Range range : rangeList) {
        if (range.contains(newRange.start())) {
          start = true;
        }
        if (range.contains(newRange.end() - 1)) {
          end = true;
        }
      }
      if (start && end && !union.contains(newRange)) {
        union.add(newRange);
      }
    }

    return union.stream().mapToLong(Range::size).sum();
  }

}

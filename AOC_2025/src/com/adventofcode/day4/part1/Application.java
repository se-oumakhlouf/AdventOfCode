package com.adventofcode.day4.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

  public static   void main(String[] args) {

    List<List<String>> grid  = new ArrayList<>();
    List<List<String>> gridCopy  = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        grid.add(List.of(line.split("")));
        gridCopy.add(new ArrayList<>(List.of(line.split(""))));
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


    int resultCount = 0;
    for (int row = 0; row < grid.size(); row++) {
      for (int cell = 0; cell < grid.get(row).size(); cell++) {
        if (grid.get(row).get(cell).equals(".")) {
          continue;
        }

        int count = 0;
        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            if (i == 0 && j == 0) {
              continue;
            }
            if ((row + i < 0 || row + i >= grid.size()) || (cell + j < 0 || cell + j >= grid.get(row + i).size())) {
              continue;
            }
            if (grid.get(row + i).get(cell + j).equals("@")) {
              count++;
            }
          }
        }

        if (count < 4) {
          resultCount++;
          gridCopy.get(row).set(cell, "X");
        }
      }
    }

    System.out.println(resultCount);
    gridPrinter(gridCopy);


  }

  private static void gridPrinter(List<List<String>> grid) {
    grid.forEach(System.out::println);
  }

}

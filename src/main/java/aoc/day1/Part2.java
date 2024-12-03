package aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/aoc/day1/input.txt"));
        List<Long> leftNumbers = new ArrayList<>();
        List<Long> rightNumbers = new ArrayList<>();

        for(String line : lines) {
            List<String> splittedLine = Arrays.stream(line.split(" {3}")).toList();
            leftNumbers.add(Long.parseLong(splittedLine.get(0)));
            rightNumbers.add(Long.parseLong(splittedLine.get(1)));
        }

        Long sumOfDifferences = 0L;
        for (Long leftNumber : leftNumbers) {
            Long occurrencesInRightNumbers = rightNumbers.stream().filter(rightNumber -> rightNumber.equals(leftNumber)).count();

            sumOfDifferences += leftNumber * occurrencesInRightNumbers;
        }

        System.out.println(sumOfDifferences);
    }
}

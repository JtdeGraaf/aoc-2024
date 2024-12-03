package aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/aoc/day1/input.txt"));
        List<Long> leftNumbers = new ArrayList<>();
        List<Long> rightNumbers = new ArrayList<>();

        for(String line : lines) {
            List<String> splittedLine = Arrays.stream(line.split(" {3}")).toList();
            leftNumbers.add(Long.parseLong(splittedLine.get(0)));
            rightNumbers.add(Long.parseLong(splittedLine.get(1)));
        }

        leftNumbers = leftNumbers.stream().sorted().toList();
        rightNumbers = rightNumbers.stream().sorted().toList();

        Long sumOfDifferences = 0L;
        for (int i = 0; i < leftNumbers.size(); i++) {
            Long leftNumber = leftNumbers.get(i);
            Long rightNumber = rightNumbers.get(i);

            sumOfDifferences += Math.abs(leftNumber - rightNumber);
        }

        System.out.println(sumOfDifferences);
    }
}

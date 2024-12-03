package aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> reports = Files.readAllLines(Paths.get("src/main/java/aoc/day2/input.txt"));

        Long amountOfSafeReports = 0L;
        for(String report: reports){
            List<Long> levels = Arrays.stream(report.split(" ")).mapToLong(Long::parseLong).boxed().toList();
            boolean isIncreasing = true;
            boolean reportIsSafe = true;
            for(int i = 1; i < levels.size(); i++) {
                Long level1 = levels.get(i - 1);
                Long level2 = levels.get(i);

                if(i == 1 && level1 > level2) {
                    isIncreasing = false;
                }
                else if(i == 1 && level1 < level2) {
                    isIncreasing = true;
                }

                if(isIncreasing && level1 > level2) {
                    reportIsSafe = false;
                }
                else if(!isIncreasing && level1 < level2) {
                    reportIsSafe = false;
                }
                else if(Math.abs(level1 - level2) < 1) {
                    reportIsSafe = false;
                }
                else if(Math.abs(level1 - level2) > 3) {
                    reportIsSafe = false;
                }
            }
            if(reportIsSafe) {
                amountOfSafeReports++;
            }
        }
        System.out.println(amountOfSafeReports);
    }
}

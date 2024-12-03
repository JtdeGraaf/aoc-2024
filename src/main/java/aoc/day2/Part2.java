package aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> reports = Files.readAllLines(Paths.get("src/main/java/aoc/day2/input.txt"));

        Long amountOfSafeReports = 0L;
        for(String report: reports){
            List<Long> originalLevels = Arrays.stream(report.split(" ")).mapToLong(Long::parseLong).boxed().toList();
            boolean reportIsSafe = isReportIsSafe(originalLevels);
            if(reportIsSafe) {
                amountOfSafeReports++;
                continue;
            }

            for(int i = 0; i < originalLevels.size(); i++) {
                ArrayList<Long> levels = new ArrayList<>(originalLevels);
                levels.remove(i);
                reportIsSafe = isReportIsSafe(levels);
                if (reportIsSafe) {
                    amountOfSafeReports++;
                    break;
                }
            }


        }
        System.out.println(amountOfSafeReports);
    }

    private static boolean isReportIsSafe(List<Long> levels) {
        boolean isIncreasing = true;
        for(int i = 1; i < levels.size(); i++) {
            Long level1 = levels.get(i - 1);
            Long level2 = levels.get(i);

            // Check if levels are increasing or decreasing
            if(i == 1 && level1 > level2) {
                isIncreasing = false;
            }
            else if(i == 1 && level1 < level2) {
                isIncreasing = true;
            }

            // Check if report is safe
            if(isIncreasing && level1 > level2) {
                return false;
            }
            else if(!isIncreasing && level1 < level2) {
                return false;
            }
            else if(Math.abs(level1 - level2) < 1) {
                return false;
            }
            else if(Math.abs(level1 - level2) > 3) {
                return false;
            }
        }
        return true;
    }
}

package aoc.day3;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> instructionLines = Files.readAllLines(Paths.get("src/main/java/aoc/day3/input.txt"));
        String instruction = String.join("", instructionLines);
        Long multiplications = 0L;

        // Find multiplications
        List<String> splittedInstruction = Arrays.stream(instruction.split("mul\\(")).toList();
        for(String split: splittedInstruction){
            // Find the first number
            StringBuilder firstNumber = new StringBuilder();
            while(StringUtils.isNumeric(split.substring(0, 1))) {
                firstNumber.append(split.charAt(0));
                split = split.substring(1);
            }
            if(split.charAt(0) != ','){
                continue;
            }
            split = split.substring(1);

            // Find the second number
            StringBuilder secondNumber = new StringBuilder();
            while(StringUtils.isNumeric(split.substring(0, 1))) {
                secondNumber.append(split.charAt(0));
                split = split.substring(1);
            }
            if(split.charAt(0) != ')'){
                continue;
            }

            multiplications += Long.parseLong(firstNumber.toString()) * Long.parseLong(secondNumber.toString());
        }
        System.out.println(multiplications);

    }
}

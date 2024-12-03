package aoc.day3;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> instructionLines = Files.readAllLines(Paths.get("src/main/java/aoc/day3/input.txt"));
        String instruction = String.join("", instructionLines);
        Long multiplications = 0L;

        // Find all instruction that have a do() more closer in front of them then a don't()
        List<String> doInstructionsSplits = Arrays.stream(instruction.split("do\\(\\)")).toList();
        StringBuilder doInstructions = new StringBuilder();
        for(String doSplit : doInstructionsSplits) {
            if(!doSplit.contains("don't()")) {
                doInstructions.append(doSplit);
                continue;
            }
            String doInstruction = doSplit.substring(0, doSplit.indexOf("don't()"));
            doInstructions.append(doInstruction);
        }

        // Find multiplications
        List<String> splittedInstruction = Arrays.stream(doInstructions.toString().split("mul\\(")).toList();
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

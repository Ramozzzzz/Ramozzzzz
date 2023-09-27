package Test;

import Operations.Calculator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void integerCalculator() {
        List<String> op1= List.of(new String[]{"1", "2", "9", "*", "+"});
        List<String> op2= List.of(new String[]{"1", "2", "+", "9", "*"});
        List<String> op3= List.of(new String[]{"20", "9", "2", "-", "+"});
        System.out.println(Calculator.integerCalculator(op1));
        System.out.println(Calculator.integerCalculator(op2));
        System.out.println(Calculator.integerCalculator(op3));
    }

    @Test
    public void fractionCalculator() {
        List<String> op1= List.of(new String[]{"1", "5", "/", "3", "5", "/", "+"});
        List<String> op2= List.of(new String[]{"4", "5", "/", "3", "5", "/", "-"});
        List<String> op3= List.of(new String[]{"1", "5", "/", "3", "5", "/", "*"});
        System.out.println(Calculator.fractionCalculator(op1));
        System.out.println(Calculator.fractionCalculator(op2));
        System.out.println(Calculator.fractionCalculator(op3));
    }
}
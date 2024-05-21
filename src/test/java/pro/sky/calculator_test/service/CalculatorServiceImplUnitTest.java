package pro.sky.calculator_test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculator_test.exceptions.ZeroDividerException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplUnitTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();

    List<Integer[]> testData = Arrays.asList(
            new Integer[]{1, 2},
            new Integer[]{2, 1},
            new Integer[]{-1, 1},
            new Integer[]{1, -1},
            new Integer[]{-1, -1},
            new Integer[]{0, 1},
            new Integer[]{1, 0}
    );

    @Test
    void hello() {
        //given
        String expected = "Добро пожаловать в калькулятор";
        //when
        String actual = calculatorService.hello();
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void plus() {
        for (Integer[] data : testData) {
            long expected = data[0] + data[1];
            long actual = calculatorService.plus(data[0], data[1]);
            assertEquals(expected, actual);
        }
    }


    @Test
    void minus() {
        for (Integer[] data : testData) {
            long expected = data[0] - data[1];
            long actual = calculatorService.minus(data[0], data[1]);
            assertEquals(expected, actual);
        }
    }

    @Test
    void multiply() {
        for (Integer[] data : testData) {
            long expected = (long) data[0] * data[1];
            long actual = calculatorService.multiply(data[0], data[1]);
            assertEquals(expected, actual);
        }
    }

    @Test
    void divide() {
        for (Integer[] data : testData) {
            if (data[1] == 0) {
                assertThrows(ZeroDividerException.class, () -> calculatorService.divide(data[0], data[1]));
            } else {
                long expected = data[0] / data[1];
                long actual = (long) calculatorService.divide(data[0], data[1]);
                assertEquals(expected, actual);
            }
        }
    }
}


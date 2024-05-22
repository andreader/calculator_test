package pro.sky.calculator_test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculator_test.exceptions.ZeroDividerException;


public class CalculatorServiceImplUnitTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();

/*    List<Integer[]> testData = Arrays.asList(
            new Integer[]{1, 2},
            new Integer[]{2, 1},
            new Integer[]{-1, 1},
            new Integer[]{1, -1},
            new Integer[]{-1, -1},
            new Integer[]{0, 1},
            new Integer[]{1, 0}
    );*/

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
        //given
        long expected1 = 3;
        long expected2 = 3;
        //when
        long actual1 = calculatorService.plus(1, 2);
        long actual2 = calculatorService.plus(2, 1);
        //then
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }


    @Test
    void minus() {
        //given
        long expected1 = -1;
        long expected2 = 1;
        //when
        long actual1 = calculatorService.minus(1, 2);
        long actual2 = calculatorService.minus(2, 1);
        //then
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void multiply() {
        //given
        long expected1 = 2;
        long expected2 = 2;
        //when
        long actual1 = calculatorService.multiply(1, 2);
        long actual2 = calculatorService.multiply(2, 1);
        //then
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    void divide() {
        //given
        float expected1 = 0.5f;
        float expected2 = 2;
        //when
        float actual1 = calculatorService.divide(1, 2);
        float actual2 = calculatorService.divide(2, 1);

        //then
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertThrows(ZeroDividerException.class, () -> calculatorService.divide(1,0));

    }
}


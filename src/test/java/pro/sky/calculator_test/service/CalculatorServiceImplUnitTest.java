package pro.sky.calculator_test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import pro.sky.calculator_test.exceptions.ZeroDividerException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplUnitTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();

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
        Assertions.assertEquals(3, calculatorService.plus(1, 2));
        Assertions.assertEquals(3, calculatorService.plus(2, 1));
        Assertions.assertEquals(0, calculatorService.plus(-1, 1));
        Assertions.assertEquals(0, calculatorService.plus(1, -1));
        Assertions.assertEquals(-2, calculatorService.plus(-1, -1));
        Assertions.assertEquals(1, calculatorService.plus(0, 1));
        Assertions.assertEquals(1, calculatorService.plus(1, 0));
        Assertions.assertEquals(2147483648L, calculatorService.plus(Integer.MAX_VALUE, 1));
        Assertions.assertEquals(-2147483647, calculatorService.plus(Integer.MIN_VALUE, 1));
    }

    @Test
    void minus() {
        Assertions.assertEquals(3, calculatorService.minus(1, 2));
        Assertions.assertEquals(3, calculatorService.minus(2, 1));
        Assertions.assertEquals(0, calculatorService.minus(-1, 1));
        Assertions.assertEquals(0, calculatorService.minus(1, -1));
        Assertions.assertEquals(-2, calculatorService.minus(-1, -1));
        Assertions.assertEquals(1, calculatorService.minus(0, 1));
        Assertions.assertEquals(1, calculatorService.minus(1, 0));
        Assertions.assertEquals(2147483648L, calculatorService.minus(Integer.MAX_VALUE, 1));
        Assertions.assertEquals(-2147483647, calculatorService.minus(Integer.MIN_VALUE, 1));
    }

    @Test
    void multiply() {
        Assertions.assertEquals(3, calculatorService.multiply(1, 2));
        Assertions.assertEquals(3, calculatorService.multiply(2, 1));
        Assertions.assertEquals(0, calculatorService.multiply(-1, 1));
        Assertions.assertEquals(0, calculatorService.multiply(1, -1));
        Assertions.assertEquals(-2, calculatorService.multiply(-1, -1));
        Assertions.assertEquals(1, calculatorService.multiply(0, 1));
        Assertions.assertEquals(1, calculatorService.multiply(1, 0));
        Assertions.assertEquals(2147483648L, calculatorService.multiply(Integer.MAX_VALUE, 1));
        Assertions.assertEquals(-2147483647, calculatorService.multiply(Integer.MIN_VALUE, 1));
    }

    @Test
    void divide() {
        Assertions.assertEquals(3, calculatorService.divide(1, 2));
        Assertions.assertEquals(3, calculatorService.divide(2, 1));
        Assertions.assertEquals(0, calculatorService.divide(-1, 1));
        Assertions.assertEquals(0, calculatorService.divide(1, -1));
        Assertions.assertEquals(-2, calculatorService.divide(-1, -1));
        Assertions.assertEquals(2147483648L, calculatorService.divide(Integer.MAX_VALUE, 1));
        Assertions.assertEquals(-2147483647, calculatorService.divide(Integer.MIN_VALUE, 1));
    }

    @Test
    void divideByZeroTest() {
        Assertions.assertThrows(ZeroDividerException.class, () -> calculatorService.divide(1, 0));
    }
}


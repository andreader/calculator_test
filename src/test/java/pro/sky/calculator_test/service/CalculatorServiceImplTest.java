package pro.sky.calculator_test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator_test.exceptions.ZeroDividerException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
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

    @ParameterizedTest
    @MethodSource("provideArgumentsForAddition")
    public void shouldReturnCorrectResultOfPlus(long num1, long num2) {
        assertEquals(num1 + num2, calculatorService.plus(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForAddition() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 1),
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(-1, -1),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForSubtraction")
    public void shouldReturnCorrectResultOfMinus(long num1, long num2) {
        assertEquals(num1 - num2, calculatorService.minus(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForSubtraction() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 1),
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(-1, -1),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForMultiplication")
    public void shouldReturnCorrectResultOfMultiply(long num1, long num2) {
        assertEquals(num1 * num2, calculatorService.multiply(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForMultiplication() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 1),
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(-1, -1),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForDivision")
    public void shouldReturnCorrectResultOfDivide(long num1, long num2) {
        assertEquals((float) num1 / num2, calculatorService.divide(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForDivision() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(2, 1),
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(-1, -1),
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 1)
        );
    }

    @Test
    void divideByZeroTest() {
        Assertions.assertThrows(ZeroDividerException.class, () -> calculatorService.divide(1, 0));
    }
}
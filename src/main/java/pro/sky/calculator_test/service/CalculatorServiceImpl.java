package pro.sky.calculator_test.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator_test.exceptions.ZeroDividerException;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public long plus(long num1, long num2) {
        return num1 + num2;
    }

    @Override
    public long minus(long num1, long num2) {
        return num1 - num2;
    }

    @Override
    public long multiply(long num1, long num2) {
        return num1 * num2;
    }

    @Override
    public float divide(long num1, long num2) {
        if (num2 == 0) {
            throw new ZeroDividerException ();
        } else {
            return (float) num1 / num2;
        }
    }
}

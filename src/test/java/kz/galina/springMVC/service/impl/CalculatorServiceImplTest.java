package kz.galina.springMVC.service.impl;

import kz.galina.springMVC.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private CalculatorService calculatorService = new CalculatorServiceImpl();

    private static Stream<Arguments> provideValuesAndResultOfMultiplication(){
        return Stream.of(

                Arguments.of(0, 45, 0.0),
                Arguments.of(89, 34, 3026.0),
                Arguments.of(-28, 30, -840.0),
                Arguments.of(0, -1, 0.0)
        );
    }

    private static Stream<Arguments> provideValuesAndResultOfAddition(){
        return Stream.of(

                Arguments.of(-14, 48, 34.0),
                Arguments.of(1267, 876, 2143.0),
                Arguments.of(-28, 30, 2),
                Arguments.of(0, -1, -1.0)
        );
    }

    private static Stream<Arguments> provideValuesAndResultOfDivision(){
        return Stream.of(

                Arguments.of(0, 45, 0.0),
                Arguments.of(45, -5, -9.0),
                Arguments.of(15, -1, -15.0)
        );
    }

    private static Stream<Arguments> provideValuesAndResultOfSubtraction(){
        return Stream.of(

                Arguments.of(0, 45, -45.0),
                Arguments.of(34, 786, -752.0),
                Arguments.of(-28, 30, -58.0),
                Arguments.of(-74, -12, -62)
        );
    }


    @ParameterizedTest
    @DisplayName("Must multiply two long values")
    @MethodSource("provideValuesAndResultOfMultiplication")
    void multiplyLongValues(long number1, long number2, double expectedResult){
        String action = "multiply";

        double result= calculatorService.calculate(number1, number2, action);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName("Must add two long values")
    @MethodSource("provideValuesAndResultOfAddition")
    void addLongValues(long number1, long number2, double expectedResult){
        String action = "add";

        double result= calculatorService.calculate(number1, number2, action);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName("Must divide two long values")
    @MethodSource("provideValuesAndResultOfDivision")
    void divideLongValues(long number1, long number2, double expectedResult){
        String action = "divide";

        double result= calculatorService.calculate(number1, number2, action);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName("Must subtract two long values")
    @MethodSource("provideValuesAndResultOfSubtraction")
    void subtractLongValues(long number1, long number2, double expectedResult){
        String action = "subtract";

        double result= calculatorService.calculate(number1, number2, action);

        assertEquals(expectedResult, result);
    }

    @Test
     void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculatorService.calculate(5, 0, "divide"));
    }

}
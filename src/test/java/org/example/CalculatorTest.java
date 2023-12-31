package org.example;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
 * 요구사항
 * 간단한 사칙연산을 할 수 있다
 * 양수로만 계산할 수 있다
 * 나눗셈에서 0을 나누는 경우 IllegalArgument예외를 발생시킨다
 * MVC패턴 기반으로 구현한다
 */
public class CalculatorTest {
    //피연산자, 연산자, 피연산자 ---> Calculator
    //          결과값        <--- Calculator
    @DisplayName("사칙 연산을 수행한다")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(1, "*", 2, 2),
                arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("분모가 0인 경우 IllegalArgumenException발생.")
    @Test
    void calculationExceptionTest(){
        assertThatCode(()-> Calculator.calculate(10,"/",0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

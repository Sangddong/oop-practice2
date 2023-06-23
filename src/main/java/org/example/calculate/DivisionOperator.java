package org.example.calculate;

import org.example.NewArthimeticOperator;

public class DivisionOperator implements NewArthimeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2==0){
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
}

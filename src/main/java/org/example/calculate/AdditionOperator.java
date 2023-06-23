package org.example.calculate;

import org.example.NewArthimeticOperator;

public class AdditionOperator implements NewArthimeticOperator {
    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

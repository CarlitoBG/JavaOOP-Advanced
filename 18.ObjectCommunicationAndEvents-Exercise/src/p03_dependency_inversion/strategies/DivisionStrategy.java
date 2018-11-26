package p03_dependency_inversion.strategies;

import p03_dependency_inversion.contracts.Strategy;

public class DivisionStrategy implements Strategy{

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
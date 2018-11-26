package p03_dependency_inversion.models;

import p03_dependency_inversion.contracts.Calculator;
import p03_dependency_inversion.contracts.Strategy;

public class PrimitiveCalculator implements Calculator{

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int performCalculation(int firstNumber, int secondNumber) {
        return this.strategy.calculate(firstNumber, secondNumber);
    }
}
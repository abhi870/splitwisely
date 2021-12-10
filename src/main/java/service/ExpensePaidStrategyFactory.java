package service;

import model.ExpensePaidType;
import strategy.ExactAmountPaidStrategy;
import strategy.ExpensePaidStrategy;
import strategy.PercentageAmountPaidStrategy;

import java.util.List;

public class ExpensePaidStrategyFactory {
    public ExpensePaidStrategy get(ExpensePaidType expensePaidType, List<Double> paidByEach, Double amount) {
        if (expensePaidType.equals(ExpensePaidType.EXACT))
            return new ExactAmountPaidStrategy(paidByEach, amount);
        else if (expensePaidType.equals(ExpensePaidType.PERCENTAGE))
            return new PercentageAmountPaidStrategy();
        else
            return null;
    }
}

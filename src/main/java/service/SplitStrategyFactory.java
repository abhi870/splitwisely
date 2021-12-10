package service;

import model.SplitType;
import strategy.SplitByPercentageStrategy;
import strategy.SplitExactStrategy;
import strategy.SplitStrategy;

import java.util.List;

public class SplitStrategyFactory {
    public SplitStrategy get(SplitType splitType, List<Double> splits, Double amount) {
        if (splitType.equals(SplitType.EXACT))
            return new SplitExactStrategy(splits, amount);
        else if (splitType.equals(SplitType.PERCENTAGE))
            return new SplitByPercentageStrategy(amount, splits);
        else return null;
    }
}

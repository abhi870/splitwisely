package strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Expense;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class SplitExactStrategy implements SplitStrategy {
    private List<Double> splits;
    private Double amount;

    @Override
    public boolean validate() {
        Optional<Double> splitTotal = splits.stream().reduce(Double::sum);
        if (!splitTotal.isPresent())
            throw new RuntimeException("split amounts not provided");
        return splitTotal.get().equals(amount);
    }
}

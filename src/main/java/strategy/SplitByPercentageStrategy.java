package strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Expense;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SplitByPercentageStrategy implements SplitStrategy {
    private Double amount;
    private List<Double> splitsByPercentage;

    @Override
    public boolean validate() {
        Optional<Double> splitByPercentageTotal = splitsByPercentage.stream().reduce((sum, current) -> sum + (current * amount));
        if (!splitByPercentageTotal.isPresent())
            throw new RuntimeException("amounts paid by percentage by each person not provided");
        return splitByPercentageTotal.get().equals(amount);
    }
}

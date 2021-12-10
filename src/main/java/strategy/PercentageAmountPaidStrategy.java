package strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Expense;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PercentageAmountPaidStrategy implements ExpensePaidStrategy {
    private List<Double> percentageAmountPaid;
    private Double amount;

    @Override
    public boolean validate() {
        Optional<Double> amountPaid = percentageAmountPaid.stream().reduce((sum, fraction) -> sum + (fraction * amount));
        if (!amountPaid.isPresent())
            throw new RuntimeException("amounts paid by each person in percentage not provided");
        return amountPaid.equals(amount);
    }
}

package strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Expense;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExactAmountPaidStrategy implements ExpensePaidStrategy {
    private List<Double> amountPaid;
    private Double amount;

    @Override
    public boolean validate() {
        Optional<Double> sumOfAmountPaid = amountPaid.stream().reduce(Double::sum);
        if (!sumOfAmountPaid.isPresent())
            throw new RuntimeException("amounts paid by each person not provided");
        return sumOfAmountPaid.get().equals(amount);
    }
}

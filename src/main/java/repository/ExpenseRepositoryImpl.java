package repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Expense;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private Map<String, Expense> expenses;

    @Override
    public Expense save(Expense expense) {
        return expenses.put(expense.getId(), expense);
    }

    @Override
    public Expense findById(String expenseId) {
        return expenses.get(expenseId);
    }

}

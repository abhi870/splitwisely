package repository;

import model.Expense;

public interface ExpenseRepository {
    Expense save(Expense expense);

    Expense findById(String expenseId);
}

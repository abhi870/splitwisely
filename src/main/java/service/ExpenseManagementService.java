package service;

import model.Expense;
import model.ExpensePaidType;
import model.SplitType;
import strategy.ExpensePaidStrategy;
import strategy.SplitStrategy;

import java.util.List;
import java.util.Map;

public interface ExpenseManagementService {
    Expense createExpenseWithoutGroup(String name
            , String description, String creatorId, double amount, List<String> users, ExpensePaidType expensePaidType, Map<String, Double> paidBy
            , SplitType splitType, List<Double> splits);

    Expense createExpenseWithGroup(String userId, double amount, String name, String description
            , String groupId, Map<String, Double> paidBy, SplitType splitType, List<Double> splits, ExpensePaidType expensePaidType);
}

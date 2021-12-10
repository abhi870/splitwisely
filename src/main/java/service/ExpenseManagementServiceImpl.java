package service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Expense;
import model.ExpensePaidType;
import model.SplitType;
import model.User;
import repository.ExpenseRepository;
import repository.UserRepository;
import strategy.ExpensePaidStrategy;
import strategy.SplitStrategy;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class ExpenseManagementServiceImpl implements ExpenseManagementService {
    private UserService userService;
    private ExpensePaidStrategyFactory expensePaidStrategyFactory;
    private SplitStrategyFactory splitStrategyFactory;
    private ExpenseRepository expenseRepository;

    @Override
    public Expense createExpenseWithoutGroup(String name
            , String description, String creatorId, double amount, List<String> users, ExpensePaidType expensePaidType, Map<String, Double> paidBy
            , SplitType splitType, List<Double> splits) {
        ExpensePaidStrategy expensePaidStrategy = expensePaidStrategyFactory.get(expensePaidType, new ArrayList<>(paidBy.values()), amount);
        SplitStrategy splitStrategy = splitStrategyFactory.get(splitType, splits, amount);
        Expense expense = null;
        if (Objects.isNull(expensePaidStrategy))
            throw new RuntimeException("expense paid not right error");
        if (Objects.isNull(splitStrategy))
            throw new RuntimeException("split type not right error");
        if (expensePaidStrategy.validate() && splitStrategy.validate()) {
            Double share = amount / users.size();
            Map<String, Double> amountOwned = new HashMap<>();
            users.forEach(userId -> amountOwned.put(userId, share));
            expense = new Expense(UUID.randomUUID().toString(), creatorId, name, amount
                    , paidBy, amountOwned);
            expenseRepository.save(expense);
            saveExpenseWithUsers(users, expense);
        }
        return expense;
    }

    @Override
    public Expense createExpenseWithGroup(String userId, double amount, String name, String description, String groupId, Map<String, Double> paidBy, SplitType splitType, List<Double> splits, ExpensePaidType expensePaidType) {
        return null;
    }

    private void saveExpenseWithUsers(List<String> users, Expense expense) {
        List<User> updatedUsers = userService.fetchAll(users);
        updatedUsers.forEach(user -> user.getExpenses().add(expense));
        userService.saveAll(updatedUsers);
    }


}

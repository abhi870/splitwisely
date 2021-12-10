import model.ExpensePaidType;
import model.SplitType;
import model.User;
import repository.ExpenseRepositoryImpl;
import repository.UserRepositoryImpl;
import service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(new HashMap<>(), new HashMap<>()));
        ExpenseManagementService expenseManagementService =
                new ExpenseManagementServiceImpl(userService, new ExpensePaidStrategyFactory()
                        , new SplitStrategyFactory(), new ExpenseRepositoryImpl(new HashMap<>()));

        //save some users
        User user1 = new User(UUID.randomUUID().toString(), "Abhishek", "abhishekpaithane@gmail.com", "8600283741", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(UUID.randomUUID().toString(), "Anil", "anilkadam@gmail.com", "9999999999", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(UUID.randomUUID().toString(), "Govind", "govinde@gmail.com", "6666666666", new ArrayList<>(), new ArrayList<>());
        userService.saveAll(Arrays.asList(user1, user2, user3));
        List<String> userIds = Arrays.asList(userService.getUserIdByName("Abhishek"), userService.getUserIdByName("Anil")
                , userService.getUserIdByName("Govind"));
        Map<String, Double> paidBy = new Hashtable<>();
        paidBy.put(userService.getUserIdByName("Abhishek"), Double.parseDouble("20"));
        paidBy.put(userService.getUserIdByName("Anil"), Double.parseDouble("10"));
        expenseManagementService.createExpenseWithoutGroup("test expense", "testing lld for splitwise", userService.getUserIdByName("Abhishek")
                , 30, userIds, ExpensePaidType.EXACT, paidBy,
                SplitType.EXACT, Arrays.asList(10.0, 10.0, 10.0));
        userService.fetchUser(userService.getUserIdByName("Abhishek")).getExpenses().forEach(expense -> System.out.println(expense.toString()));
    }
}

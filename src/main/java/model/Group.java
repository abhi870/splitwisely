package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
    private String id;
    private String name;
    private String description;
    private List<User> users;
    private List<Expense> expenses;
}

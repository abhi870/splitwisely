package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String mob;
    private List<Group> groups;
    private List<Expense> expenses;
}

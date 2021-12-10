package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expense {
    private String id;
    private String creatorId;
    private String name;
    private Double amount;
    private Map<String, Double> paidBy;
    private Map<String, Double> amountOwned;
}

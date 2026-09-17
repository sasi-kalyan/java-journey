package io.expense.tracker.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {
    private Long id;
    private String expenseType;
    private String expenseDesc;
    private Double amount;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

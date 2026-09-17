package io.expense.tracker.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseType;
    private String expenseDesc;
    private Double amount;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomUser user;

    @Override
    public String toString() {
        return  "{" +
                    "id=" + id +
                    ", expenseType='" + expenseType + '\'' +
                    ", expenseDesc='" + expenseDesc + '\'' +
                    ", amount=" + amount +
                '}';
    }
}

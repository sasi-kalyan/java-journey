package io.expense.tracker.app.repository;

import io.expense.tracker.app.entity.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Query("""
            SELECT e FROM Expense e WHERE
            e.user.id = :userId AND
            e.createdAt BETWEEN :startDate AND :endDate
           """)
        List<Expense> findExpenseBetweenDates(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}

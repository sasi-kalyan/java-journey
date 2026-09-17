package io.expense.tracker.app.service;

import io.expense.tracker.app.entity.Expense;
import io.expense.tracker.app.model.ExpenseDTO;

import java.time.LocalDate;
import java.util.Date;

public interface ExpenseService {
    ExpenseDTO addExpense(Long id, ExpenseDTO expenseDTO);

    boolean deleteExpense(Long id);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void getUserExpenseFileByDateRange(Long id, LocalDate date1, LocalDate date2);
}

package io.expense.tracker.app.converter;

import io.expense.tracker.app.entity.Expense;
import io.expense.tracker.app.model.ExpenseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ExpenseConverter {
    public Expense expenseDtoToEntity(ExpenseDTO expenseDTO){
        Expense expense = new Expense();
        expense.setExpenseType(expenseDTO.getExpenseType());
        expense.setExpenseDesc(expenseDTO.getExpenseDesc());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCreatedAt(getLocalDateTime());
        expense.setUpdatedAt(getLocalDateTime());
        return expense;
    }

    public ExpenseDTO expenseEntityToDto(Expense expense){
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId(expense.getId());
        expenseDTO.setExpenseType(expense.getExpenseType());
        expenseDTO.setExpenseDesc(expense.getExpenseDesc());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setCreatedAt(expense.getCreatedAt());
        expenseDTO.setUpdatedAt(expense.getUpdatedAt());

        return expenseDTO;
    }

    public Expense updateExpense(Expense expense, ExpenseDTO expenseDTO){
        if(expenseDTO.getExpenseType() != null){
            expense.setExpenseType(expenseDTO.getExpenseType());
        }
        if(expenseDTO.getExpenseDesc() != null){
            expense.setExpenseDesc(expenseDTO.getExpenseDesc());
        }
        if(expenseDTO.getAmount() != null){
            expense.setAmount(expenseDTO.getAmount());
        }
        expense.setUpdatedAt(getLocalDateTime());

        return expense;
    }

    public LocalDate getLocalDateTime(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
        return localDate;
    }
}

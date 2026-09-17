package io.expense.tracker.app.controller;

import io.expense.tracker.app.model.ExpenseDTO;
import io.expense.tracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/expense/v1")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService invokeExpenseService) {
        expenseService = invokeExpenseService;
    }

    @PostMapping("/new-expense/{userId}")
    public ResponseEntity<ExpenseDTO> addExpense(@PathVariable("userId") Long id, @RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO expenseDTO1 = expenseService.addExpense(id, expenseDTO);
        ResponseEntity<ExpenseDTO> responseEntity = new ResponseEntity<>(expenseDTO1, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/delete-expense/{id}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable("id") Long id){
        Boolean deleteFlag = expenseService.deleteExpense(id);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(deleteFlag, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/update-expense")
    public ResponseEntity<ExpenseDTO>updateExpense(@RequestParam Long id, @RequestBody ExpenseDTO expenseDTO){
        ExpenseDTO expenseDTO1 = expenseService.updateExpense(id, expenseDTO);
        ResponseEntity<ExpenseDTO> responseEntity = new ResponseEntity<>(expenseDTO1, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/get-expenses-by-date-range/{id}")
    public void getUserExpenseFileByDateRange(@PathVariable("id") Long id, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        expenseService.getUserExpenseFileByDateRange(id, startDate, endDate);
    }
}

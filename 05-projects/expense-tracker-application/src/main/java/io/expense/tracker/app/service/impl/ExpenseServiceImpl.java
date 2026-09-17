package io.expense.tracker.app.service.impl;

import io.expense.tracker.app.converter.ExpenseConverter;
import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.entity.Expense;
import io.expense.tracker.app.model.ExpenseDTO;
import io.expense.tracker.app.repository.CustomUserRepository;
import io.expense.tracker.app.repository.ExpenseRepository;
import io.expense.tracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CustomUserRepository customUserRepository;
    private ExpenseConverter expenseConverter;

    @Autowired
    ExpenseServiceImpl(ExpenseRepository iExpenseRepository, CustomUserRepository icustomUserRepository,
                       ExpenseConverter iExpenseConverter){
        expenseRepository = iExpenseRepository;
        customUserRepository = icustomUserRepository;
        expenseConverter = iExpenseConverter;
    }

    @Override
    public ExpenseDTO addExpense(Long id, ExpenseDTO expenseDTO) {
        Optional<CustomUser> customUser = customUserRepository.findById(id);
        Expense expense = null;
        if(customUser.isPresent()){
            expense = expenseConverter.expenseDtoToEntity(expenseDTO);
            expense.setUser(customUser.get());
            expenseRepository.save(expense);
        }
        return expenseConverter.expenseEntityToDto(expense);
    }

    @Override
    public boolean deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
           Expense expense = optionalExpense.get();
           Expense newExpense = expenseConverter.updateExpense(expense, expenseDTO);
           expenseRepository.save(newExpense);
           ExpenseDTO expenseDTO1 = expenseConverter.expenseEntityToDto(newExpense);
           return expenseDTO1;
        }
        return null;
    }

    @Override
    public void getUserExpenseFileByDateRange(Long id, LocalDate startDate, LocalDate endDate) {
        List<Expense> expensesList = expenseRepository.findExpenseBetweenDates(id, startDate, endDate);
        try{
            generateExpenseFile(id, expensesList);
        }catch (IOException e){
            System.out.println("exception occurred");
        }
    }

    public void generateExpenseFile(Long id, List<Expense> expenseList) throws FileNotFoundException {
        String FILE = "Expense_Statement_"+String.valueOf(id + "_")+String.valueOf(LocalDate.now());
        String savePath = "src/main/resources/util/"+FILE;
        String fullFilePath = savePath;

        try(FileOutputStream fos = new FileOutputStream(fullFilePath, true)){
            for(Expense e : expenseList){
                fos.write((e.toString()+"\n").getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

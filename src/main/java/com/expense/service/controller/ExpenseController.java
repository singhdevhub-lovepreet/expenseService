package com.expense.service.controller;

import com.expense.service.dto.ExpenseDto;
import com.expense.service.service.ExpenseService;
import jakarta.websocket.server.PathParam;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController
{

    private final ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping(path = "/expense/v1/")
    public ResponseEntity<List<ExpenseDto>> getExpense(@PathParam(value = "user_id") @NonNull String userId){
         try{
            List<ExpenseDto> expenseDtoList = expenseService.getExpenses(userId);
            return new ResponseEntity<>(expenseDtoList, HttpStatus.OK);
         }catch(Exception ex){
             return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         }
    }

}

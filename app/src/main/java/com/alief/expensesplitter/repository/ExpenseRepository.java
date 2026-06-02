package com.example.yourapp.repository;

import android.content.Context;

import com.example.yourapp.dao.ExpenseDao;
import com.example.yourapp.database.AppDatabase;
import com.example.yourapp.model.Expense;

import java.util.List;

public class ExpenseRepository {

    private final ExpenseDao expenseDao;

    public ExpenseRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        expenseDao = db.expenseDao();
    }

    public void insert(Expense expense) {
        new Thread(() -> expenseDao.insert(expense)).start();
    }

    public void delete(Expense expense) {
        new Thread(() -> expenseDao.delete(expense)).start();
    }

    public List<Expense> getByProjectId(int projectId) {
        return expenseDao.getByProjectId(projectId);
    }
}
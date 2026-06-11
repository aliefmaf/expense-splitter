package com.alief.expensesplitter.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.alief.expensesplitter.dao.ExpenseDao;
import com.alief.expensesplitter.database.AppDatabase;
import com.alief.expensesplitter.model.Expense;

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

    public LiveData<List<Expense>> getExpensesByProjectId(int projectId) {
        return expenseDao.getExpensesByProjectId(projectId);
    }
}
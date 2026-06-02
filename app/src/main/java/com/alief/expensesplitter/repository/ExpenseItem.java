package com.example.yourapp.repository;

import android.content.Context;

import com.example.yourapp.dao.ExpenseItemDao;
import com.example.yourapp.database.AppDatabase;
import com.example.yourapp.model.ExpenseItem;

import java.util.List;

public class ExpenseItemRepository {

    private final ExpenseItemDao expenseItemDao;

    public ExpenseItemRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        expenseItemDao = db.expenseItemDao();
    }

    public void insert(ExpenseItem item) {
        new Thread(() -> expenseItemDao.insert(item)).start();
    }

    public void delete(ExpenseItem item) {
        new Thread(() -> expenseItemDao.delete(item)).start();
    }

    public List<ExpenseItem> getByExpenseId(int expenseId) {
        return expenseItemDao.getByExpenseId(expenseId);
    }
}
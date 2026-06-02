package com.example.yourapp.repository;

import android.content.Context;

import com.example.yourapp.dao.ExpenseItemSplitDao;
import com.example.yourapp.database.AppDatabase;
import com.example.yourapp.model.ExpenseItemSplit;

import java.util.List;

public class ExpenseItemSplitRepository {

    private final ExpenseItemSplitDao dao;

    public ExpenseItemSplitRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        dao = db.expenseItemSplitDao();
    }

    public void insert(ExpenseItemSplit split) {
        new Thread(() -> dao.insert(split)).start();
    }

    public void delete(ExpenseItemSplit split) {
        new Thread(() -> dao.delete(split)).start();
    }

    public List<ExpenseItemSplit> getByExpenseItemId(int expenseItemId) {
        return dao.getByExpenseItemId(expenseItemId);
    }
}
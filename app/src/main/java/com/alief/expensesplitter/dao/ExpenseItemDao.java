package com.alief.expensesplitter.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alief.expensesplitter.model.ExpenseItem;

import java.util.List;

@Dao
public interface ExpenseItemDao {

    @Insert
    void insert(ExpenseItem expenseItem);

    @Delete
    void delete(ExpenseItem expenseItem);

    @Query("SELECT * FROM expenseitem WHERE expenseId = :expenseId")
    LiveData<List<ExpenseItem>> getItemsByExpenseId(int expenseId);
}

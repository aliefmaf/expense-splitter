package com.alief.expensesplitter.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alief.expensesplitter.model.ExpenseItemSplit;

import java.util.List;

@Dao
public interface ExpenseItemSplitDao {

    @Insert
    void insert(ExpenseItemSplit expenseItemSplit);

    @Delete
    void delete(ExpenseItemSplit expenseItemSplit);

    @Query("SELECT * FROM expenseitemsplit WHERE expenseItemId = :expenseItemId")
    LiveData<List<ExpenseItemSplit>> getSplitsByExpenseItemId(int expenseItemId);
}

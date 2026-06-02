package com.alief.expensesplitter.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alief.expensesplitter.model.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert
    void insert(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query("SELECT * FROM expense WHERE projectId = :projectId")
    LiveData<List<Expense>> getExpensesByProjectId(int projectId);
}

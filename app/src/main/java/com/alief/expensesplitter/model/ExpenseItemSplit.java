package com.alief.expensesplitter.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
        tableName = "expenseitemsplit",
        primaryKeys = {"expenseItemId", "personId"},
        foreignKeys = {
                @ForeignKey(
                        entity = ExpenseItem.class,
                        parentColumns = "id",
                        childColumns = "expenseItemId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Person.class,
                        parentColumns = "id",
                        childColumns = "personId",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class ExpenseItemSplit {
    public int expenseItemId;
    public int personId;

    // derive amount from ExpenseItemSplit
}
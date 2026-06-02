package com.alief.expensesplitter.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(
        tableName = "expenseitem",
        foreignKeys = {
                @ForeignKey(
                        entity = Expense.class,
                        parentColumns = "id",
                        childColumns = "expenseId",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class ExpenseItem {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int expenseId;
    public String itemName;
    public double itemPrice;


}


package com.alief.expensesplitter.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(
        tableName = "expense",
        foreignKeys = {
                @ForeignKey(
                        entity = Project.class,
                        parentColumns = "id",
                        childColumns = "projectId",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class Expense {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int projectId;
    public String description;
    public double taxAmount;
    public String date;

    // Derive subtotal from ExpenseItem
}


package com.alief.expensesplitter.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.alief.expensesplitter.dao.ExpenseDao;
import com.alief.expensesplitter.dao.ExpenseItemDao;
import com.alief.expensesplitter.dao.ExpenseItemSplitDao;
import com.alief.expensesplitter.dao.PersonDao;
import com.alief.expensesplitter.dao.ProjectDao;
import com.alief.expensesplitter.model.Expense;
import com.alief.expensesplitter.model.ExpenseItem;
import com.alief.expensesplitter.model.ExpenseItemSplit;
import com.alief.expensesplitter.model.Project_Person;
import com.alief.expensesplitter.model.Person;
import com.alief.expensesplitter.model.Project;

@Database(
        entities = {
                Project.class,
                Person.class,
                Project_Person.class,
                Expense.class,
                ExpenseItem.class,
                ExpenseItemSplit.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    // DAO methods
    public abstract ProjectDao projectDao();

    public abstract PersonDao personDao();

    public abstract ExpenseDao expenseDao();

    public abstract ExpenseItemDao expenseItemDao();

    public abstract ExpenseItemSplitDao expenseItemSplitDao();

    // Singleton instance
    public static synchronized AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "expense_tracker_db"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
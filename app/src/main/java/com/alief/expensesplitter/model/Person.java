package com.alief.expensesplitter.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String telno;
}

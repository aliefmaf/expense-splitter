package com.alief.expensesplitter.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "project")
public class Project {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String createdDate;
}
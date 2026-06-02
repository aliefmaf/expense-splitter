package com.alief.expensesplitter.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
        tableName = "project_person",
        primaryKeys = {"projectId", "personId"},
        foreignKeys = {
                @ForeignKey(
                        entity = Project.class,
                        parentColumns = "id",
                        childColumns = "projectId",
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
public class Project_Person {
    public int projectId;
    public int personId;
}

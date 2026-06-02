package com.alief.expensesplitter.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alief.expensesplitter.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {

    @Insert
    void insert(Project project);

    @Delete
    void delete(Project project);

    @Query("SELECT * FROM project")
    LiveData<List<Project>> getAllProjects();
}

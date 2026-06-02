package com.alief.expensesplitter.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alief.expensesplitter.model.Project_Person;

import java.util.List;

@Dao
public interface Project_PersonDao {

    @Insert
    void insert(Project_Person project_person);

    @Delete
    void delete(Project_Person project_person);

    @Query("SELECT * FROM project_person WHERE projectId = :projectId")
    LiveData<List<Project_Person>> getPersonsByProjectId(int projectId);
}

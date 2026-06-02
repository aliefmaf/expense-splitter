package com.example.yourapp.repository;

import android.content.Context;

import com.example.yourapp.dao.Project_PersonDao;
import com.example.yourapp.database.AppDatabase;
import com.example.yourapp.model.Project_Person;

import java.util.List;

public class Project_PersonRepository {

    private final Project_PersonDao dao;

    public Project_PersonRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        dao = db.projectPersonDao();
    }

    public void insert(Project_Person projectPerson) {
        new Thread(() -> dao.insert(projectPerson)).start();
    }

    public void delete(Project_Person projectPerson) {
        new Thread(() -> dao.delete(projectPerson)).start();
    }

    public List<Project_Person> getPersonsByProjectId(int projectId) {
        return dao.getPersonsByProjectId(projectId);
    }
}
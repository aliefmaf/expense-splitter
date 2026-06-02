package com.alief.expensesplitter.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.alief.expensesplitter.dao.ProjectDao;
import com.alief.expensesplitter.database.AppDatabase;
import com.alief.expensesplitter.model.Project;

import java.util.List;

public class ProjectRepository {

    private final ProjectDao projectDao;

    public ProjectRepository(Context context) {

        AppDatabase db = AppDatabase.getInstance(context);
        projectDao = db.projectDao();
    }

    // INSERT
    public void insert(Project project) {
        new Thread(() -> {
            projectDao.insert(project);
        }).start();
    }

    // GET ALL
    public LiveData<List<Project>> getAllProjects() {
        return projectDao.getAllProjects();
    }

    // DELETE
    public void delete(Project project) {
        new Thread(() -> {
            projectDao.delete(project);
        }).start();
    }
}
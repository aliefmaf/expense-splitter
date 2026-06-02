package com.example.yourapp.repository;

import android.content.Context;

import com.example.yourapp.dao.PersonDao;
import com.example.yourapp.database.AppDatabase;
import com.example.yourapp.model.Person;

import java.util.List;

public class PersonRepository {

    private final PersonDao personDao;

    public PersonRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        personDao = db.personDao();
    }

    public void insert(Person person) {
        new Thread(() -> personDao.insert(person)).start();
    }

    public void delete(Person person) {
        new Thread(() -> personDao.delete(person)).start();
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }
}
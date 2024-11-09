package com.example.cruddemo.service;

import com.example.cruddemo.dao.AppRepo;
import com.example.cruddemo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class AppServiceImpl implements AppService  {

    private AppRepo appRepo;



    @Autowired
    public AppServiceImpl(AppRepo appRepo) {
        this.appRepo = appRepo;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        appRepo.save(instructor);
    }

    @Override
    public Optional<Instructor> findById(int id) {
        return appRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        appRepo.deleteById(id);
    }
}

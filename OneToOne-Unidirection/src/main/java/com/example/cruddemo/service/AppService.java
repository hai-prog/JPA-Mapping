package com.example.cruddemo.service;

import com.example.cruddemo.entity.Instructor;

import java.util.Optional;

public interface AppService {

    void save(Instructor instructor);

    Optional<Instructor> findById(int id);

    void deleteById(int id);
}

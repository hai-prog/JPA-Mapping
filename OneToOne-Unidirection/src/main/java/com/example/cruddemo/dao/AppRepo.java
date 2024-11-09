package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<Instructor,Integer> {
}

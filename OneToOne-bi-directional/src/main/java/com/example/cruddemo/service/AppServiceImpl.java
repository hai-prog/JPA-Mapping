package com.example.cruddemo.service;

import com.example.cruddemo.dao.InstructorDetailsRepo;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class AppServiceImpl implements AppService  {


private InstructorDetailsRepo instructorDetailsRepo;

@Autowired
    public AppServiceImpl(InstructorDetailsRepo instructorDetailsRepo) {
        this.instructorDetailsRepo = instructorDetailsRepo;
    }




//    @Override
//    @Transactional
//    public void save(Instructor instructor) {
//        instructorDetailsRepo.save(instructor);
//    }
//
//    @Override
//    public Optional<Instructor> findById(int id) {
//        return instructorRepo.findById(id);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        instructorRepo.deleteById(id);
//    }

    @Override
    public Optional<InstructorDetail> findInstructorDetailsById(int theId) {
        return instructorDetailsRepo.findById(theId);
    }



    @Override
    public void deleteInstructorDetails(int theId) {
        instructorDetailsRepo.deleteById(theId);
    }
}

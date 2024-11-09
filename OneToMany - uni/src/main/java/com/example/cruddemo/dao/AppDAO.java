package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructor(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> getCoursesByInstructorId(int theId);

    void updateInstructor(Instructor instructor);

    void saveCourse(Course course);
    Course findCourseAndReviewsByCourseId(int theId);

    void deleteCourse(int theId);
}

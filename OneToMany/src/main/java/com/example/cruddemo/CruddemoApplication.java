package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);

    }
        @Bean
        public CommandLineRunner commandLineRunner(AppDAO appDAO) {

            return runner -> {

               //  createInstructorWithCourses(appDAO);
              //   findCoursesForInstructor(appDAO);
              //  updateInstructor(appDAO);

                deleteInstructor(appDAO);
            };
        }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;

        // delete his instructor
        appDAO.deleteInstructor(theId);

    }

    private void updateInstructor(AppDAO appDAO) {


        int theId = 1;
        // find the instructor
       Instructor tempInstructor = appDAO.findInstructorById(theId);

       // update an instructor last name
        tempInstructor.setLastName("Test");

        appDAO.updateInstructor(tempInstructor);
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int theId = 1;

        // find the instructor
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor : " +tempInstructor);

        // find the courses for this instructor
        List<Course> associatedCourses = appDAO.getCoursesByInstructorId(theId) ;

        // associate the courses
        tempInstructor.setCourses(associatedCourses);
        System.out.println("The associated courses : " + tempInstructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

       //  create instructor
        Instructor instructor = new Instructor("Haidy","osama","haid@gmail.com");

        // create instructor details

        InstructorDetail instructorDetail= new InstructorDetail("haidy@youtube.com","cycling");

        // associate the instructor and th instructor details
        instructor.setInstructorDetail(instructorDetail);

        // create courses

        Course course1 = new Course("Math");
        Course course2 = new Course("Arabic");
        Course course3 = new Course("English");

        // associate the instructor and the courses
        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);


        appDAO.save(instructor);
    }


}

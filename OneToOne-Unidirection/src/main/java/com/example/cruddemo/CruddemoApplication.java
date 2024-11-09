package com.example.cruddemo;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import com.example.cruddemo.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);

    }
        @Bean
        public CommandLineRunner commandLineRunner(AppService appDAO) {

            return runner -> {
            //    createInstructor(appDAO);

                findInstructor(appDAO);
                deleteInstructor(appDAO);
            };
        }

    private void deleteInstructor(AppService appDAO) {
        int id = 2;

        appDAO.deleteById(id);

        System.out.println("the instructor with id "+ id+ " is deleted");
    }

    private void findInstructor(AppService appDAO) {

        int theId = 5;

        System.out.println("Finding instructor with id" + theId);

        Optional<Instructor> tempInstructor = appDAO.findById(theId);

        System.out.println("the instructor :" + tempInstructor);


    }

    private void createInstructor(AppService appDAO) {

//        // create instructor
//        Instructor instructor = new Instructor("Haidy","osama","haid@gmail.com");
//
//        // create instructor details
//
//        InstructorDetail instructorDetail= new InstructorDetail("haidy@youtube.com","cycling");
//
//        // associate the instructor and th instructor details
//        instructor.setInstructorDetail(instructorDetail);
//
//        appDAO.save(instructor);

        // create instructor
        Instructor instructor2 = new Instructor("Rana","osama","ra@gmail.com");

        // create instructor details

        InstructorDetail instructorDetail2= new InstructorDetail("rana@youtube.com","horseriding");

        // associate the instructor and th instructor details
        instructor2.setInstructorDetail(instructorDetail2);

        appDAO.save(instructor2);
    }


}

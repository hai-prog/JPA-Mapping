package com.example.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;



    @ManyToMany(fetch = FetchType.LAZY ,cascade ={ CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinTable(
            name = "course_student" ,
            joinColumns = @JoinColumn(name = "student_id") ,
            inverseJoinColumns =  @JoinColumn(name = "course_id") )
    private List<Course> courses ;


   public void addCourse(Course theCourse)
   {
       if( courses== null)
       {
           courses = new ArrayList<>();
       }

       courses.add(theCourse);
   }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

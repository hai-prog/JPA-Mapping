package com.example.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;



    @ManyToOne(cascade ={ CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id" )
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY ,cascade ={ CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinTable(
            name = "course_student" ,
            joinColumns = @JoinColumn(name = "course_id") ,
            inverseJoinColumns =  @JoinColumn(name = "student_id")
    )
    private List<Student> students ;

    public void addStudent(Student theStudent)
    {

        if (students== null)
        {
            students = new ArrayList<>();
        }

        students.add(theStudent);
    }

    public void addReview(Review review)
    {
        if (reviews== null)
        {
            reviews = new ArrayList<>();
        }

        reviews.add(review);

    }

    public Course(String title) {
        this.title = title;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
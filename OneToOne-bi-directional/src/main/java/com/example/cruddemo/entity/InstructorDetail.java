package com.example.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "instructor_detail")
@Data
public class InstructorDetail {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail" , cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail() {
    }
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}

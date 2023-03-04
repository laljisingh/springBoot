package com.laljisingh.hibernateMapping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer student_Id;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;

    @Embedded
    private Address address;

    @JsonIgnore
    @OneToOne(mappedBy = "student")
    private Hostel hostel;

    @JsonIgnore
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "studentList",cascade = CascadeType.ALL)
    List<Course> courseList = new ArrayList<>();
}

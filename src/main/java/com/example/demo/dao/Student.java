package com.example.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "Student")
//@table is used to have full controll over table names & all
@Table(
        name = "student",
        uniqueConstraints = {@UniqueConstraint(name = "student_email_unique",columnNames = "email")}
)
//default entity name is class name
public class Student {
    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName ="student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "first_name",nullable = false,columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name",nullable = false,columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email",nullable = false,columnDefinition = "TEXT")
    private String email;
    @Column(name = "age",nullable = false)
    private Integer age;
}

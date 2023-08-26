package ru.hogwarts.school.model;

import jakarta.persistence.*;


@Entity
@Table(name = "STUDENTS")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
@ManyToOne
@JoinColumn(name = "faculty_id")
    private Faculty faculty;




    public Student(Faculty faculty) {

        this.faculty = faculty;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }





    public Student(String name, int age, Faculty faculty) {
        this.name = name;
        this.age = age;

        this.faculty = faculty;
    }
    public Student() {

    }
}

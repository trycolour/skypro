package ru.hogwarts.school.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "FACULTIES")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String color;
    @OneToMany(mappedBy = "faculty")


    private Collection<Student> students;




    public Faculty(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;

    }

    public Faculty(Collection<Student> students) {
        this.students = students;
    }

    public Faculty() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



}

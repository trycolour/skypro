package ru.hogwarts.school.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FACULTIES")

public class Faculcy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String color;

    public Faculcy(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
    public Faculcy(){}

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

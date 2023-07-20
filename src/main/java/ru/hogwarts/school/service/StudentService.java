package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculcy;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service

public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long idCount;
    //CREATE
    public Student addStudent(Student student) {
        student.setId(idCount++);
        students.put(idCount, student);
        return student;
    }
    //READ
    public Student returnStudent(long id) {
        return students.get(id);
    }
    //UPDATE
    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(),student);
            return student;
        }
        else
            return null;
    }
    //DELETE
    public Student deleteStudent(long id) {
        return students.remove(id);

    }
    //фильтрация по возрасту
    public Collection<Student> sortingStudent(Long age) {
        Collection<Student> sortedStudents = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                sortedStudents.add(student);
            }
        }




        return sortedStudents;
    }

}

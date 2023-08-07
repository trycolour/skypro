package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import ru.hogwarts.school.reposy.StudentRepository;

@Service

public class StudentService {
    private final StudentRepository studentRepository;
    private long idCount;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    //CREATE
    public Student addStudent(Student student) {

return studentRepository.save(student);
    }
    //READ
    public Student returnStudent(long id) {
        return studentRepository.findById(id).get();
    }
    //UPDATE
    public Student editStudent(Student student) {
        return studentRepository.save(student);

    }
    //DELETE
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);

    }
    //фильтрация по возрасту
   /* public Collection<Student> sortingStudent(Long age) {
        Collection<Student> sortedStudents = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                sortedStudents.add(student);
            }
        }




        return sortedStudents;
    } */

}

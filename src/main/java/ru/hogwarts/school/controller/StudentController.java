package ru.hogwarts.school.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.AvatarService;
import ru.hogwarts.school.service.StudentService;

import java.io.IOException;
import java.util.Collection;

@RestController
public class StudentController {
    private final StudentService studentService;
    private final AvatarService avatarService;

    public StudentController(StudentService studentService, AvatarService avatarService) {
        this.studentService = studentService;
        this.avatarService = avatarService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id) {
        Student student = studentService.returnStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);

    }

    @GetMapping("/sortbyage/{age}")
    ResponseEntity<Collection<Student>> sortByAge(@PathVariable Long age) {
        Collection<Student> result = studentService.findByAge(age);
        if (result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping


    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @GetMapping("/getallstudents")
    public ResponseEntity<Collection<Student>> findAllStudents() {
        Collection<Student> students = studentService.getAllStudents();
        if (students == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);

    }
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @GetMapping("/filter")
    public Collection<Student> findByAgeBetween(@RequestParam int ageFrom, @RequestParam int ageTo) {
        return studentService.findAllByAgeBetween(ageFrom,ageTo);

    }

    @GetMapping("/findbyfaculty")
    public Collection<Student> findStudentsByFacultyId(@RequestParam long id) {
        return studentService.findAllByFacultyId(id);

    }
    @GetMapping("/findstudentfaculy")
    public Faculty findStudentFaculty(@RequestParam long id) {
        return studentService.findFacultyStudent(id);

    }




}


package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")


public class StudentController {
private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
    ResponseEntity<Collection<Student>> sortByAge(@PathVariable long age) {
        Collection<Student> result = studentService.sortingStudent(age);
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


@DeleteMapping("{id}")
public Student deleteStudent(@PathVariable Long id) {
return studentService.deleteStudent(id);
}
}

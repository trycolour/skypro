package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController



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


@DeleteMapping("{id}")
public void deleteStudent(@PathVariable Long id) {
studentService.deleteStudent(id);
}
}

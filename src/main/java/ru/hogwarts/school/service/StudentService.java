package ru.hogwarts.school.service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.reposy.StudentRepository;
import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


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
    public Collection<Student> findByAge(Long age) {
        return studentRepository.findByAge(age);

        }


    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Collection<Student> findAllByAgeBetween(int ageFrom, int ageTo) {
        return studentRepository.findAllByAgeBetween(ageFrom,ageTo);
    }
    public Collection<Student> findAllByFacultyName(String name) {
        return studentRepository.findStudentsByFaculty_Name(name);
    }






}





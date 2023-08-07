package ru.hogwarts.school.reposy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {
}

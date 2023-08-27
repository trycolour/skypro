package ru.hogwarts.school.reposy;

import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(Long age);

    Collection<Student> findAllByAgeBetween(int ageFrom, int ageTo);

    Collection<Student> findAllByFaculty_Id(long id);



}

    







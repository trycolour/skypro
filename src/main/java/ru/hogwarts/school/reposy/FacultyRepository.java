package ru.hogwarts.school.reposy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculcy;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculcy, Long> {
    Collection<Faculcy> findByColor(String color);
}

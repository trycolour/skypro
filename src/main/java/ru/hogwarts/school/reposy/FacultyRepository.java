package ru.hogwarts.school.reposy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColor(String color);
    Collection<Faculty> findFacultyByColorIgnoreCaseOrNameIgnoreCase(String name, String color);


}

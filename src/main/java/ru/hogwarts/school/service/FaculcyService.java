package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.reposy.FacultyRepository;

import java.util.Collection;

@Service

public class FaculcyService {
    private final FacultyRepository facultyRepository;
    public FaculcyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    //CREATE
    public Faculty addFaculcy(Faculty faculty) {
        return facultyRepository.save(faculty);

    }
    //READ
    public Faculty returnFaculcy(long id) {
        return facultyRepository.findById(id).get();
    }
    //UPDATE
    public Faculty editFaculcy(Faculty faculty) {
        return facultyRepository.save(faculty);

    }
    //DELETE
    public void deleteFaculcy(long id) {
        facultyRepository.deleteById(id);

    }
    //фильтрация по цвету
    public Collection<Faculty> sortingByColor(String color) {
return facultyRepository.findByColor(color);
    }


    public Collection<Faculty> findAllByColorOrName(String colorOrName, String colorOrName1) {
        return facultyRepository.findFacultyByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName1);
    }
}

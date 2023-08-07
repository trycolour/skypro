package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculcy;
import ru.hogwarts.school.reposy.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service

public class FaculcyService {
    private final FacultyRepository facultyRepository;
    public FaculcyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    //CREATE
    public Faculcy addFaculcy(Faculcy faculcy) {
        return facultyRepository.save(faculcy);

    }
    //READ
    public Faculcy returnFaculcy(long id) {
        return facultyRepository.findById(id).get();
    }
    //UPDATE
    public Faculcy editFaculcy(Faculcy faculcy) {
        return facultyRepository.save(faculcy);

    }
    //DELETE
    public void deleteFaculcy(long id) {
        facultyRepository.deleteById(id);

    }
    //фильтрация по цвету
    public Collection<Faculcy> sortingByColor(String color) {
return facultyRepository.findByColor(color);
    }

}

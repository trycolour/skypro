package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculcy;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service

public class FaculcyService {
    private final HashMap<Long, Faculcy> faculties = new HashMap<>();
    private long idCount;
    //CREATE
    public Faculcy addFaculcy(Faculcy faculcy) {
        faculcy.setId(idCount++);
        faculties.put(idCount, faculcy);
        return faculcy;
    }
    //READ
    public Faculcy returnFaculcy(long id) {
        return faculties.get(id);
    }
    //UPDATE
    public Faculcy editFaculcy(Faculcy faculcy) {
        if (faculties.containsKey(faculcy.getId())) {
            faculties.put(faculcy.getId(),faculcy);
            return faculcy;
        }
        else
            return null;
    }
    //DELETE
    public Faculcy deleteFaculcy(long id) {
        return faculties.remove(id);

    }
    //фильтрация по цвету
    public Collection<Faculcy> sortingByColor(String color) {
Collection<Faculcy> sortedFaculcy = new ArrayList<>();
for (Faculcy faculcy : faculties.values()) {
    if (faculcy.getColor() == color) {
        sortedFaculcy.add(faculcy);
    }
}
return sortedFaculcy;
    }

}

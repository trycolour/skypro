package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FaculcyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")


public class FacultyController {
    private final FaculcyService faculcyService;

    public FacultyController(FaculcyService faculcyService) {
        this.faculcyService = faculcyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long id) {
        Faculty faculty = faculcyService.returnFaculcy(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);

    }

    @GetMapping("/sortbycolor/{color}")
    ResponseEntity<Collection<Faculty>> sortByColor(@PathVariable String color) {
        Collection<Faculty> result = faculcyService.sortingByColor(color);
        if (result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping
    public Faculty addFaculcy(@RequestBody Faculty faculty) {
        return faculcyService.addFaculcy(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = faculcyService.editFaculcy(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }


    @DeleteMapping("{id}")
    public void deleteFaculcy(@PathVariable Long id) {
        faculcyService.deleteFaculcy(id);
    }
    @GetMapping("/finbycolororname")
    public Collection<Faculty> findByColorOrName(@RequestParam String colorOrName) {
        return faculcyService.findAllByColorOrName(colorOrName, colorOrName);
    }

}

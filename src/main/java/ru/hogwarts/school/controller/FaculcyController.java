package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculcy;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FaculcyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")


public class FaculcyController {
private final FaculcyService faculcyService;
    @GetMapping
    public String getApi() {
        return "Приложение работает";
    }

    public FaculcyController(FaculcyService faculcyService) {
        this.faculcyService = faculcyService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculcy> findFaculty(@PathVariable Long id) {
        Faculcy faculcy = faculcyService.returnFaculcy(id);
        if (faculcy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculcy);

    }
    @GetMapping("/sortbycolor/{color}")
    ResponseEntity<Collection<Faculcy>> sortByColor(@PathVariable String color) {
        Collection<Faculcy> result = faculcyService.sortingByColor(color);
        if (result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }



    @PostMapping
    public Faculcy addFaculcy(@RequestBody Faculcy faculcy) {
        return faculcyService.addFaculcy(faculcy);
    }
    @PutMapping
    public ResponseEntity<Faculcy> editFaculty(@RequestBody Faculcy faculcy) {
        Faculcy foundFaculcy = faculcyService.editFaculcy(faculcy);
        if (foundFaculcy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculcy);
    }


    @DeleteMapping("{id}")
    public Faculcy deleteFaculcy(@PathVariable Long id) {
        return faculcyService.deleteFaculcy(id);
    }

}

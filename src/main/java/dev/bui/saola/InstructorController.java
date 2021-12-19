/*

package dev.bui.saola;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
//@RequestMapping("/api")
class InstructorController {
    private final InstructorRepository repo;

    public InstructorController(InstructorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/instructors")
    Iterable<Instructor> all() {
        return this.repo.findAll();
    }

    @PostMapping("/instructors")
    Instructor newInstructor(@RequestBody Instructor newInstructor) {
        return this.repo.save(newInstructor);
    }

    @GetMapping("/instructors/{id}")
    Instructor one(@PathVariable Long id) {
        Instructor i = this.repo.findById(Long.toString(id));
        if (i != null) {
            return i;
        }

        throw new InstructorNotFoundException(id);
    } 

    @PutMapping("/instructors/{id}")
    Instructor replaceInstructor(@RequestBody Instructor newInstructor, @PathVariable Long id) {
        Instructor i = this.repo.findById(Long.toString(id));

        if (i != null) {
            i.setName(newInstructor.getName());
            return this.repo.save(i);
        }

        newInstructor.setId(id);
        return this.repo.save(newInstructor);
    }

    @DeleteMapping("/instructors/{id}")
    void deleteInstructor(@PathVariable Long id) {
        this.repo.deleteById(Long.toString(id));
    }
}*/

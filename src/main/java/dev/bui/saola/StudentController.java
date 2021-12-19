package dev.bui.saola;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

//should really return an EntityResponse so that response codes can be included

@RestController
@RequestMapping("/api/students")
class StudentController {
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Student> all() {
        return this.repo.findAll();
    }

    @PostMapping
    public Student newStudent(@RequestBody Student newStudent) {
        return this.repo.save(newStudent);
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable Long id) {
        Student s = this.repo.findById(Long.toString(id));
        if (s != null) {
            return s;
        }

        throw new StudentNotFoundException(id);
    } 

    @PutMapping("/{id}")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        Student s = this.repo.findById(Long.toString(id));

        if (s != null) {
            s.setName(newStudent.getName());
            //need to set other fields here - need to make sure that other fields are auto-filled
            return this.repo.save(s);
        }

        throw new StudentNotFoundException(id);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        this.repo.deleteById(Long.toString(id));
    }
}

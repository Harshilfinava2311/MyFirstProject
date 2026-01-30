package MyFirstProject1.controller;

import MyFirstProject1.entity.Student;
import MyFirstProject1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudents(@RequestBody Student s) {
        return service.saveStudent(s);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{myid}")
    public Optional<Student> getById(@PathVariable String myid) {
        return service.findById(myid);
    }

    @DeleteMapping("/{myid}")
    public Boolean delete(@PathVariable String myid) {
        service.deleteStudent(myid);
        return true;
    }

    @PutMapping("/{myid}")
    public Student update(@PathVariable String myid, @RequestBody Student s) {
        Student old = service.findById(myid).orElse(null);

        if (old != null) {

            old.setName(s.getName() != null && !s.getName().isEmpty() ? s.getName() : old.getName());
            old.setEmail(s.getEmail() != null && !s.getEmail().isEmpty() ? s.getEmail() : old.getEmail());
            old.setCourse(s.getCourse() != null && !s.getCourse().isEmpty() ? s.getCourse() : old.getCourse());

            return service.saveStudent(old);  // save only if found
        } else {
            throw new RuntimeException("Student not found with Id: " + myid);
        }


    }


}

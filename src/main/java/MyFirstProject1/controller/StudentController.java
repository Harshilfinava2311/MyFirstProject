package MyFirstProject1.controller;

import MyFirstProject1.entity.Student;
import MyFirstProject1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController{

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getall(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student s){
        return service.saveStudent(s);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStudents(@PathVariable String id){
        service.deleteStudent(id);
        return true;
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id,@RequestBody Student s){
        Student old=service.findById(id).orElse(null);

        if (old!=null){
            old.setName(old.getName()!=null && !old.getName().isEmpty() ? s.getName() : old.getName() );
            old.setEmail(old.getEmail()!=null && !old.getEmail().isEmpty()?s.getEmail():old.getEmail());
            old.setCourse(old.getCourse()!=null && !old.getCourse().isEmpty() ? s.getCourse() : old.getCourse());
            return service.saveStudent(old);
        }else {
            throw new RuntimeException("Student not found by id : "+id);
        }

    }
}



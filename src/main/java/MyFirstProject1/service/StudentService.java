package MyFirstProject1.service;

import MyFirstProject1.Repository.StudentRepository;
import MyFirstProject1.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    private StudentRepository srepo;

    public Student saveStudent(Student student){
        return srepo.save(student);
    }

    public List<Student> getAllStudents(){
        return srepo.findAll();
    }

    public Optional<Student> findById(String id){
        return srepo.findById(id);
    }

    public void deleteStudent(String id){
        srepo.deleteById(id);
    }

}

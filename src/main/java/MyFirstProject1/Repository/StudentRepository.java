package MyFirstProject1.Repository;


import MyFirstProject1.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String>{

}
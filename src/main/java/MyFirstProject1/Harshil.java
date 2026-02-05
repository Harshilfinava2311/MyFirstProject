package MyFirstProject1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Document(collection = "harshil")
@Data
public class Harshil {
    @Id
    private String id;
    private String hname;
    private int age;
}

interface HarshilRepository extends MongoRepository<Harshil, String> {

}

@RestController
@RequestMapping("/harshil")
class Controller {
    @Autowired
    private HarshilRepository harshilRepository;

    @GetMapping
    public List<Harshil> getAll() {
        return harshilRepository.findAll();
    }

    @PostMapping
    public Harshil add(@RequestBody Harshil h) {
        return harshilRepository.save(h);
    }

    @DeleteMapping("/{id}")
    public Harshil delete(@PathVariable String id) {
        Harshil old = harshilRepository.findById(id).orElse(null);
        if (old != null) {
            harshilRepository.deleteById(id);
        }
        return old;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Harshil harshil) {

        Harshil old = harshilRepository.findById(id).orElse(null);
        if (old != null) {
            old.setHname(harshil.getHname() != null && !harshil.getHname().equals("") ? harshil.getHname() : old.getHname());
            old.setAge(harshil.getAge() != 0 ? harshil.getAge() : old.getAge());
            harshilRepository.save(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
    }

}

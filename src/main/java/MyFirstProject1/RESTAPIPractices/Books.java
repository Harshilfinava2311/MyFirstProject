package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Books {
    private long id;
    private String name;
    private String author;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

@RestController
@RequestMapping("/books")
class BookManagerController{

    private Map<Long,Books> map=new HashMap<>();

    //get all
    @GetMapping
    public List<Books> get(){
        return new ArrayList<>(map.values());
    }

    //get by id
    @GetMapping("/id/{id}")
    public Books getById(@PathVariable long id){
        return map.get(id);
    }

    //insert
    @PostMapping
    public Books insert(@RequestBody Books books){
        map.put(books.getId(),books);
        return books;
    }

    //delete
    @DeleteMapping("/id/{id}")
    public Books delete(@PathVariable long id){
        return map.remove(id);
    }

    //update
    @PutMapping("/id/{myid}")
    public Books update(@PathVariable long myid,@RequestBody Books books){
        map.put(myid,books);
        return books;
    }

}

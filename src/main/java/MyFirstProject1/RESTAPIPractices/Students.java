package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students {
    private long id;
    private String name;
    private int age;
    private String course;
    private Boolean active;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

@RestController
@RequestMapping("/students")
class StudentsController{

    private Map<Long,Students> map=new HashMap<>();

    //get
    @GetMapping
    public List<Students> get(){
        return new ArrayList<>(map.values());
    }

    //get by id
    @GetMapping("/id/{id}")
    public Students getById(@PathVariable long id){
        return map.get(id);
    }

    //insert
    @PostMapping
    public Students insert(@RequestBody Students students){
        map.put(students.getId(), students);
        return students;
    }

    //update
    @PutMapping("/id/{id}")
    public Students update(@RequestBody Students students,@PathVariable long id){
        students.setId(id);
        map.put(id, students);
        return students;
    }

    //delete
    @DeleteMapping("/id/{id}")
    public Students delete(@PathVariable long id){
        return map.remove(id);
    }

    @GetMapping("/active")
    public List<Students> getActive(){
        List<Students> list=new ArrayList<>();

        for (Students s:map.values()){
            if (s.getActive()!=null && s.getActive()){
                list.add(s);
            }
        }
        return list;
    }

}


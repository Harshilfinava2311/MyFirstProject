package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes {
    private long id;
    private String title;
    private String description;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

@RestController
@RequestMapping("/notes")
class NotesController {
    private Map<Long, Notes> map = new HashMap<>();

    @GetMapping
    public List<Notes> getdata() {
        return new ArrayList<>(map.values());
    }

    @GetMapping("/id/{myid}")
    public Notes getById(@PathVariable long myid) {
        return map.get(myid);
    }

    @PostMapping
    public Notes post(@RequestBody Notes note) {
        map.put(note.getId(), note);
        return note;
    }

    @DeleteMapping("/id/{myid}")
    public Notes delete(@PathVariable long myid) {
        return map.remove(myid);
    }

    @PutMapping("/id/{myid}")
    public Notes update(@PathVariable long myid,
                        @RequestBody Notes note) {
        map.put(myid, note);
        return note;
    }

}

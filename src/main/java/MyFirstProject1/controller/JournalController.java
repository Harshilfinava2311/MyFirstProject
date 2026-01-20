//package MyFirstProject.controller;
//
//import MyFirstProject.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalController {
//
//    private Map<Long, JournalEntry> map = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll() {
//        return new ArrayList<>(map.values());
//a
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry) {
//
//        map.put(Long.valueOf(myEntry.getId().getTimestamp()), myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myid}")
//    public JournalEntry getJournalEntryId(@PathVariable long myid) {
//        return map.get(myid);
//    }
//
//    @DeleteMapping("/id/{myid}")
//    public JournalEntry deleteJournalEntryById(@PathVariable long myid) {
//        return map.remove(myid);
//    }
//
//    @PutMapping("/id/{id}")
//    public JournalEntry updateJournalById(@PathVariable long id, @RequestBody JournalEntry entry) {
//        return map.put(id, entry);
//    }
//}

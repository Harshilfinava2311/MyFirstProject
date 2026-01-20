package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGet {

    @GetMapping("/user/{name}")
    public User getuser(@PathVariable String name){
        return new User( name, "active");
    }

}

//or using map
//@RestController
//public class UserGet {
//
//    @GetMapping("/user/{name}")
//    public Map<String, String> getUser(@PathVariable String name) {
//        Map<String, String> result = new HashMap<>();
//        result.put("name", name);
//        result.put("status", "active");
//
//        return result;
//    }
//}

package MyFirstProject1;

import MyFirstProject1.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name){
        return "Welcome to Spring Boot  😍😍😍 " +name;
    }

}

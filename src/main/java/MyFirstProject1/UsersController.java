package MyFirstProject1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/users")
    public List<Users> getuser(){
        return List.of(new Users("Harshil",23),new Users("Vraj",17),
                new Users("Hasti",10));
    }
//    public Users getuser(){
//        return new Users("Harshil",20);
//    }
}

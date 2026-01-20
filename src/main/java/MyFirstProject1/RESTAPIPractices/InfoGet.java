package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoGet{

    @GetMapping("/info")
    public List<Info> getinfo(){
        return List.of(
                new Info("Instagram","1.0","Harshil"),
                new Info("WhatsApp","2.0","Vraj"));
    }
}

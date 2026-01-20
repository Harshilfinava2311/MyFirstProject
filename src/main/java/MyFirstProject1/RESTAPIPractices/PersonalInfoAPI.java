package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonalInfoAPI {

    @GetMapping("/profile/name")
    public String name(){
        return "Harshil";
    }

    @GetMapping("/profile/age")
    public String age(){
        return "21";
    }

    @GetMapping("/profile/city")
    public String city(){
        return "Ahmedabad";
    }

    @GetMapping("/profile/info")
    public Map<String,String> getdata(){
        Map<String,String> map=new HashMap<>();
        map.put("Name",name());
        map.put("Age",age());
        map.put("City",city());
        return map;
    }
//    public List<Object> getInfo(){
//
//        //or direct
////        return "Name: Harshil, Age: 21, City: Ahmedabad";
////        return "Name : "+name()+" , Age : "+age()+" , City : "+city();
//        return List.of("Name"+name(),"Age"+age(),"City"+city());
//    }

}

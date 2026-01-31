package MyFirstProject1.RESTAPIPractices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//Q9️⃣ Boolean Response
//API: /isAdult/{age}
//Example: /isAdult/20

//Output:
//{
//  "adult": true
//}

@RestController
public class IsAdult {

    @GetMapping("/isAdult/{age}")
    public Map<String ,Boolean> isAdult(@PathVariable int age){
        Boolean isAdult=false;
        if (age>=18){
            isAdult=true;
        }if (age>=100){
            isAdult=false;
        }
        Map<String,Boolean> map=new HashMap<>();
        map.put("adult",isAdult);
//       Easy way to get boolean value directly without if else
//       map.put("adult",age>=18);
        return map;
    }
}

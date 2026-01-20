package MyFirstProject1.RESTAPIPractices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SumAandB {

//    @GetMapping("/add")
//    public Map<String ,Integer> summing(
//            @RequestParam(defaultValue = "0") int a,
//            @RequestParam int b){
//        Map<String,Integer> result=new HashMap<>();
//        result.put("sum",a+b);
//        return result;
//    }


    //or
    @GetMapping("/add/{a}/{b}")
    public Map<String ,Integer> sum(@PathVariable int a,@PathVariable int b){
        int sum=a+b;
        Map<String ,Integer> map=new HashMap<>();
        map.put("Sum",sum);
        return map;
    }



}

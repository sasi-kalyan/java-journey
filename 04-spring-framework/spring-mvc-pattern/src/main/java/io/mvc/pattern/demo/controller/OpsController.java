package io.mvc.pattern.demo.controller;

import io.mvc.pattern.demo.model.OpsDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ops")
public class OpsController {
    //http://localhost:8080/api/v1/user/add
    //RequestParam usage
    @GetMapping("/add")
    public Integer sendUser(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b){
        return a+b;
    }


    //PathVariable usage
    //http://localhost:8080/api/v1/user/sub/4.5/7.9
    @GetMapping("/sub/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        if(num1 > num2){
            return num1 - num2;
        }
        return num2 - num1;
    }

    //http://localhost:8080/api/v1/user/mul/3?num1=10
    @GetMapping("/mul/{num2}")
    public Integer multiply(@RequestParam("num1") Integer num1, @PathVariable("num2") Integer num2){
        return num1*num2;
    }

    @PostMapping("/addAll")
    public ResponseEntity<Double> addAll(@RequestBody OpsDto opsDto){
        Double result = opsDto.getNum1()+opsDto.getNum2()+ opsDto.getNum3()+opsDto.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}

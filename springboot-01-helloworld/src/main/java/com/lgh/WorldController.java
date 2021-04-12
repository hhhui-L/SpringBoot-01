package com.lgh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @RequestMapping("/w")
    public String word66(){
        return "word";
    }
}

package com.tmnt.test.moshtest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class NestedPath {

    @GetMapping("/try4")
    public String try4(){
        return "well man this is try4";
    }

    @PostMapping("nameSend")
    public String hiSend(){
       return "working on it";
    }


}

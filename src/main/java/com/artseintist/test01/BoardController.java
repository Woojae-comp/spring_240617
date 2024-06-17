package com.artseintist.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/boards")
public class BoardController {

    @RequestMapping(value="/gallery")
    public String gallery() {
        return "boards/gallery";
    }

    @RequestMapping(value="/free")
    public String free() {
        return "boards/free";
    }
}

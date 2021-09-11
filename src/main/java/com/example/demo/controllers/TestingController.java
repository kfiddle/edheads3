package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestingController {

    //    @RequestMapping("/teachers-test")
//    public String displayTeachersTestPage() {
//
//        return "teacherResources";
//    }

    @RequestMapping("/basic-page")
    public String displayBasicPage() {

        return "basicPage";
    }

}

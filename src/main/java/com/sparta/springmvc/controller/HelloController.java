package com.sparta.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Controller라면 이 어노테이션을 달아주어야 작동한다.
@RequestMapping("/api") // 모든 *Mapping의 상단에 경로 일괄 적용
public class HelloController {

    @GetMapping("/hello") // '/hello'로 GET요청이 들어올 때, 아래를 실행해라
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //아래 return문에서 {data} 속성에 "hello!!"를 대입해라!
        return "hello"; // 'templates/'에서 'hello'+'.html'을 찾아라!
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}

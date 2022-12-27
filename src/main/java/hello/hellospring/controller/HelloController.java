package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello") // 웹어플에서 슬래쉬 hello = /hello 가 들어오면 밑에 헬로문을 호출한다??
    public String hello(Model model)
    {
        model.addAttribute("data", "메건!!");
        return "hello";
    }

    @GetMapping("fromis")
    public String fromis(Model model)
    {
        model.addAttribute("data", "하냥!!");
        return "fromis";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) // 외부에서 name을 받음
    {
        model.addAttribute("name", name);
        return "hello-template";
    }
}

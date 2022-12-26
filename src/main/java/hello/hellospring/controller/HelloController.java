package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

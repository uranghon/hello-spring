package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("name2222", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 바디부에 밑에 return 값을 바로 넣어주겠다. 즉 페이지소스보기 했을때 return 값이 바로 보임.
    public String hellostring(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    } // JSON 방식

    //static 클래스로 만들면 클래스 안에서 클래스 또 만들어 쓸 수 있다.
    static class Hello
    {
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    } // 게터세터. 자바빈 표준방식. 프로퍼티 방식

}

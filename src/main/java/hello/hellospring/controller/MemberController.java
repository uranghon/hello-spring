package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링 빈으로 등록하는기능?
public class MemberController {
    private final MemberService memberService;
    // 위에 new 로 인스턴스화 해도 되지만 아래처럼 생성자 통해 하는 이유?
    // memberService 에 별 기능 없다. 여러개 생성해서 쓸 필요 없다.
    // 스프링 컨테이너에 딱 하나만 등록해서 쓰면 된다.
    // 밑에처럼 생성자에 @Autowired 를 선언해서 쓰면
    // 스프링 컨테이너가 멤버컨트롤러 생성할 때
    // 스프링 컨테이너 안에 있는 멤버서비스를 가져다가 생성자에 넣어준다.
    // 근데 가져다 쓸라면 쓸라는 놈도 빈으로 설정되어있어야 한다.

//    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member);
        //System.out.println("이름 : " + form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

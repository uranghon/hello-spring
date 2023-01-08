package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // 이렇게 하면 보면 밑에 MemoryMemberRepository 는 사실 join 같은 기능을 통해 실행되는 MemberService 에 이미 생성되어 있다.
    // 그래서 뭔가뭔가 두번 new 하는게 이상하다. 지금이야 뭐 변수 부분이 다 static 이라 상관없지만 아닐경우 뭔가뭔가 발생할수도
    // 때문에 바꿔야 한다.
    /*
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    */
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);
        Member findMember = memberService.findOne(saveId).get();

        //then
        assertThat(member.getName()).isEqualTo(findMember.getName());
        System.out.println("회원Id : " + saveId);
    }

    @Test
    void 중복_회원_처리_테스트() {

        //given
        Member member1 = new Member();
        member1.setName("멤버1");

        Member member2 = new Member();
        member2.setName("멤버1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
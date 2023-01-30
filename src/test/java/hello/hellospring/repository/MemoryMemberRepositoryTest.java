package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result);
        //org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
        assertThat(result).isEqualTo(member);
        System.out.println(member.getId());
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        System.out.println("result = " + (result == member1));
//        Assertions.assertEquals(member1, result);
        //org.assertj.core.api.Assertions.assertThat(member1).isEqualTo(result);
//        assertThat(result).isEqualTo(member1);
//        System.out.println(member1.getName() +);
    }

    @Test
    public void findById() {
        Member member = new Member();


    }

    @Test
    public void findAll() {
//given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
//when
//        List<Member> result = repository.findAll();
        List<Member> result = repository.findAll();
//then
        assertThat(result.size()).isEqualTo(2);


    }

}

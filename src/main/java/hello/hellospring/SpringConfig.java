package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*
        private final DataSource dataSource;
        private final EntityManager em;
        @Autowired
        public SpringConfig(DataSource dataSource, EntityManager em) {
            this.dataSource = dataSource; // 들어오는 dataSource는 설정파일 통해 스프링 컨테이너가 스프링 빈으로 생성해놓은 dataSource
            this.em = em;
        }
        */
    private final MemberRepository memberRepository;

    //  여기서 자동으로 SpringDataJpaMemberRepository 구현체랑 연결된다.
    //  왜 그렇게 되냐? 스프링 컨테이너에 빈으로 등록된 MemberRepository 타입 클래스가 하나밖에 없음! 밑에 봐라 다른애들 빈에서 뻈잖슴.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(this.dataSource);
//        return new JpaMemberRepository(em);
//    }

    /*@Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
}

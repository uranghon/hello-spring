package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    public static long sequence = 0L;

    public int intT;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

        //findAny는 꼭 첫번째꺼가 아니네 name 중에 어떤거라도 가져올 수 있네
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Member> findByNameAll(String name)
    {
        return new ArrayList<>((Collection) store.values().stream()
                .filter(member -> member.getName().contains(name))
        );
    }

    public void clearStore() {
        store.clear();
    }
}

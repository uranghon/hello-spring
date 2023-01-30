package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 디비가 id 알아서 생성해주는걸 IDENTITY 전략이라고 한다.
    private Long id;

    //@Column(name = "USERNAME")
    // 만약에 DB의 컬럼명은 USERNAME 이고, 코드에서는 밑의 걍 name로 쓰겠다 하면 이렇게 @Column 을 통해 이름을 넣어줘야한다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

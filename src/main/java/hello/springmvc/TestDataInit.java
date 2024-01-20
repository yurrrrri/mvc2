package hello.springmvc;

import hello.springmvc.itemservice.domain.item.Item;
import hello.springmvc.itemservice.domain.item.ItemRepository;
import hello.springmvc.itemservice.domain.member.Member;
import hello.springmvc.itemservice.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("tester");
        memberRepository.save(member);
    }
}

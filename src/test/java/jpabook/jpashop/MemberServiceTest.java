package jpabook.jpashop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        /*Member member = new Member();
        member.setName("kim");*/
        Member member = Member.builder().name("kim").build();

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        /*
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");*/
        Member member1 = Member.builder().name("kim").build();
        Member member2 = Member.builder().name("kim").build();

        //when
        memberService.join(member1);
        memberService.join(member2); // 예외 발생

        //then
        fail("member2 join 호출 시 예외가 발생해야 한다");
    }

}

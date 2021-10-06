package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    // 싱글톤이기 때문에 new 로 객체 생성 X
    MemberRepository memberRepository = MemberRepository.getInstance();

    //test가 끝나면 테스트를 초기화하기 위한 어노테이션
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member  = new Member("xonmin",24);
        //when
        Member savemember = memberRepository.save(member);
        //then
        Member findMember =  memberRepository.findById(savemember.getId());
        assertThat(findMember).isEqualTo(savemember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 24);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }


}
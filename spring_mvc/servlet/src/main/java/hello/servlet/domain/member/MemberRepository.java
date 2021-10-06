package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // 실무에서는 동시성 문제를 고려하므로, ConcurrentHashMap , AtomicLong 을 사용
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =  0L;


    //싱글톤으로  생성
    private static final MemberRepository instance = new MemberRepository();

    public static  MemberRepository getInstance(){
        return instance;
    }
    //싱글톤으로 만들 때는 private으로 생성을 아무나 할 수 없도록 막아야함
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        //new arraylist에서 store 안에 있는 값들을 건들이고 싶지 않아서
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

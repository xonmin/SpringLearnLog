package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    //멀티 쓰레드 환경에서는 hashmap을 사용해선 X
    // 멀티 스레드 환경에서는 hashmap이 아닌 concurrentHashmap 을 사용

    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence =  0L; //static

    public Item save(Item item){
        item.setId(++ sequence);
        store.put(item.getId() , item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        // 제대로 할 거면 여기서 updateParam 에 id를 안쓰기 떄문에
        // dto를 만들어 여기에는 id를 제외한 세가지 멤버 변수만 넣어서 사용하는 것이 더 명확한 것
        // 중복이냐 명확성이냐 -> 명확성

        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    public void clearStore(){
        store.clear();
    }

}

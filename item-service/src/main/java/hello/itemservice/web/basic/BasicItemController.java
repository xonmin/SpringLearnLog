package hello.itemservice.web.basic;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor  //final 이 있으면 자동으로 생성자를 만들고 주입해준다
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }


    // 데이터 등록이 아닌 폼만 보여주는 것
    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    //같은 url이지만 method로 나누기
    //@PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);

        model.addAttribute("item" , item);

        return "basic/item";
    }
    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){

        itemRepository.save(item);

        //model.addAttribute("item" , item); // 얘는 자동 추가 되기 때문에 생략 가능

        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){

        itemRepository.save(item);

        //model.addAttribute("item" , item); // 얘는 자동 추가 되기 때문에 생략 가능

        return "basic/item";
    }
    //@PostMapping("/add")
    public String addItemV4( Item item){

        itemRepository.save(item);

        //model.addAttribute("item" , item); // 얘는 자동 추가 되기 때문에 생략 가능

        return "basic/item";
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item) ;
        return "redirect:/basic/items/{itemId}";
    }

    //test 용
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 100000,10));
        itemRepository.save(new Item("itemB", 200000,20));

    }



}

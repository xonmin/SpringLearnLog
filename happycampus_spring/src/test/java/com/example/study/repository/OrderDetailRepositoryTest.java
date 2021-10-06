package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();


        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setStatus("Waiting");
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));

        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");
      //  orderDetail.setOrderGroup(1L); // 어떠한 장바구니
        //orderDetail.setItemId(1L);  //어떠한 상품

        OrderDetail neworderDetail =orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(neworderDetail);
    }
}

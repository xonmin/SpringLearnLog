package com.example.study.repository;


import com.example.study.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
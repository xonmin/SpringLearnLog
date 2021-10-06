package com.example.study.model.entity;


import com.example.study.model.enumclass.PartnerStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = {"itemList","categoty"})
@EntityListeners(AuditingEntityListener.class)
@Builder

@Accessors(chain = true)
public class Partner {
    // entiny 를 작성할 때는 camel case
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PartnerStatus status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private  LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private  LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //Categoty 1 : N partner
    @ManyToOne
    private Category category;

    // Partner 1: N item
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "partner")
    private List<Item> itemList;

}

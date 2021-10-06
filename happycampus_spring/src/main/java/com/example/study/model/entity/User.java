package com.example.study.model.entity;

import com.example.study.model.enumclass.UserStatus;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // =table
@ToString(exclude = {"user"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User {
    //jpa entity 는 camel case -> DB의 snake_case로 바꾼다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //어떤식으로 관리할 것인지.
    private  Long id;

    private  String account;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private  String email;
    private  String phoneNumber;


    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private  LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;


    // User 1 : n OrderGroup
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<OrderGroup> orderGroupList;


}

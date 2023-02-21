package com.emlakcepte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "orderNo")
    private Long orderNo;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity = 10;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Date createdDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Date expiredDate;

    @ManyToMany
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name="users_products",
            joinColumns = {@JoinColumn(name="product_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")})
    private List<User> users = new ArrayList<>();

    public void addUserToProduct(User user) {
        users.add(user);
    }

}

package com.emlakcepte.model;

import com.emlakcepte.model.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "userQuantity")
    private Integer userQuantity = 0;
    @JsonSerialize(using= LocalDateSerializer.class)
    private Date packageStartedDate = new Date();
    @JsonSerialize(using= LocalDateSerializer.class)
    private Date packageExpiredDate = new Date();

    @ManyToMany
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();


    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Realty>realties = new ArrayList<>();

    public void addProductToUser(Product product) {
        products.add(product);
    }
}

package com.emlakcepte.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banners")
@Builder
@EqualsAndHashCode
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long realtyNo;

    private String title;
    private String phone;
    private Integer quantity;

    @OneToOne
    private Address address;

}

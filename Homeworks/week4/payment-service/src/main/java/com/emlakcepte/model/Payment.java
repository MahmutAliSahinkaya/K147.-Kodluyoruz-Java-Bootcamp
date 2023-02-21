package com.emlakcepte.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
@Builder
@EqualsAndHashCode
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "productId")
    private Long productId;
    @Column(name = "orderNo")
    private Long orderNo;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "is_pay")
    private Boolean isPay;


}

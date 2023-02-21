package com.emlakcepte.model;

import com.emlakcepte.model.enums.RealtyType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "realties")
@Builder
@EqualsAndHashCode
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "realty_no", nullable = false)
    private Long realtyNo;
    @Column(name = "realty_type")
    @Enumerated(value = EnumType.STRING)
    private RealtyType realtyType = RealtyType.IN_REVIEW;
    @Column(name = "title", length = 200)
    private String title;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "created_date")
    private Date createdDate = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Realty() {
        this.realtyType = RealtyType.IN_REVIEW;
        this.createdDate = new Date();
    }
    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }

}



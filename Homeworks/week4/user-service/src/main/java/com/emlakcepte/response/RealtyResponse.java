package com.emlakcepte.response;

import com.emlakcepte.model.User;
import com.emlakcepte.model.enums.RealtyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealtyResponse {
    private Long id;
    private Long userId;
    private Long realtyNo;
    private RealtyType realtyType;
    private String title;
    private String province;
    private String district;
    private Date createdDate;
    private User user;


}

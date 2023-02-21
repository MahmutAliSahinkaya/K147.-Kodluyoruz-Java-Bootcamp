package com.emlakcepte.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {
    private Long realtyNo;
    private String title;
    private String phone;
    private Integer quantity;


}
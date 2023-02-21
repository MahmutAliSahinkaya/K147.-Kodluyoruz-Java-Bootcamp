package com.emlakcepte.request;

import com.emlakcepte.model.enums.RealtyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealtyRequest {
    private Long userId;
    private Long realtyNo;
    private RealtyType realtyType;
    private String title;


}

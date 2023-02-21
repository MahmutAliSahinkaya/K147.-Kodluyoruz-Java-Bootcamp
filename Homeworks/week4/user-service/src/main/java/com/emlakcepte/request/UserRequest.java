package com.emlakcepte.request;

import com.emlakcepte.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {
    private Long id;
    private UserType userType;
    private String name;
    private String email;
    private String password;



}

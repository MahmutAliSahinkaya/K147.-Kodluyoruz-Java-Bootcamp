package com.emlakcepte.response;

import com.emlakcepte.model.Product;
import com.emlakcepte.model.Realty;
import com.emlakcepte.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class UserResponse {
    private Long id;
    private UserType userType;
    private String name;
    private String email;
    private String password;
    private Integer quantity;
    private Date startedDate;
    private Date expiredDate;
    private Set<Product> products;
    private List<Realty> realties;

}

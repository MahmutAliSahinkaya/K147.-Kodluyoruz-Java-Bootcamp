package com.emlakcepte.controller;

import com.emlakcepte.model.Product;
import com.emlakcepte.request.UserRequest;
import com.emlakcepte.response.UserResponse;
import com.emlakcepte.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/getById")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/getIdIfQuantityExist/{userId}")
    public Object getIdIfQuantityExist(@PathVariable Long userId) {
        return userService.getIdIfQuantityExist(userId);
    }

    @GetMapping(value = "/packages/{userId}")
    public List<Product> getPackagesByUserId(@PathVariable Long userId) {
        return userService.getPackagesByUserId(userId);
    }

    @PostMapping
    public UserResponse add(@RequestBody UserRequest userRequest) {
        return userService.add(userRequest);
    }

    @PutMapping
    public UserResponse update(@RequestBody UserRequest userRequest) {
        return userService.update(userRequest);
    }

    @PutMapping(value = "/{userId}/products/{productId}")
    public UserResponse updateQuantitiesAndDates(@PathVariable Long userId, @PathVariable Long productId) {
        return userService.updateQuantitiesAndDates(userId, productId);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}

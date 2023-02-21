package com.emlakcepte.service;

import com.emlakcepte.converter.UserConverter;
import com.emlakcepte.model.User;
import com.emlakcepte.model.Product;
import com.emlakcepte.repository.ProductRepository;
import com.emlakcepte.repository.UserRepository;
import com.emlakcepte.request.UserRequest;
import com.emlakcepte.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ProductRepository productRepository;

    private boolean validateUser(User user) {
        boolean isValid = true;
        if (user.getName() == null || user.getName().isEmpty()) {
            isValid = false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            isValid = false;
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            isValid = false;
        }
        if (user.getUserType() == null) {
            isValid = false;
        }
        return isValid;
    }

    public List<UserResponse> getAll() {
        List<UserResponse> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(userConverter.convert(user));
        }
        log.info("Listed all users.");
        return users;
    }

    public UserResponse getById(Long id) {
        User user = userRepository.getById(id);
        return userConverter.convert(user);
    }


    public List<Product> getPackagesByUserId(Long userId) {
        User user = userRepository.getById(userId);
        if (!validateUser(user)) {
            System.out.println("Invalid user.");
            return Collections.emptyList();
        }
        return new ArrayList<>(user.getProducts());
    }

    public Object getIdIfQuantityExist(Long userId) {
        User user = userRepository.getById(userId);
        if (!validateUser(user)) {
            System.out.println("Invalid user.");
            return Collections.emptyList();
        } else {
            if (user.getUserQuantity() > 0) {
                user.setUserQuantity(user.getUserQuantity() - 1);
                return userRepository.save(user);
            } else {
                return null;
            }
        }
    }

    public UserResponse add(UserRequest userRequest) {
        User user = userConverter.convert(userRequest);
        log.info("User has been created.");
        return userConverter.convert(userRepository.save(user));
    }

    public UserResponse update(UserRequest userRequest) {
        userRepository.findById(userRequest.getId());
        User user = new User();
        if (!validateUser(user)) {
            System.out.println("Invalid user.");
        } else {
            user.setId(userRequest.getId());
            user.setUserType(userRequest.getUserType());
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            log.info("User has been updated.");
            return userConverter.convert(userRepository.save(user));
        }
        return null;
    }

    public UserResponse updateQuantitiesAndDates(Long userId, Long productId) {
        User user = userRepository.getById(userId);
        Product product = productRepository.getById(productId);
        if (!validateUser(user)) {
            System.out.println("Invalid user.");
        } else {

            if (user.getId() != null) {
                Date expired = new Date(user.getPackageExpiredDate().getTime() + (1000L * 60 * 60 * 24 * 30));
                user.setPackageStartedDate(user.getPackageStartedDate());
                user.setPackageExpiredDate(expired);

                user.setUserQuantity(user.getUserQuantity() + product.getQuantity());

                product.addUserToProduct(user);
                user.addProductToUser(product);
                log.info("Package has been added to User.");
                return userConverter.convert(userRepository.save(user));
            } else {
                System.out.println("Payment Invalid!");
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        User user = userRepository.getById(id);
        if (!validateUser(user)) {
            System.out.println("Invalid user.");
        } else {
            getById(id);
            userRepository.deleteById(id);
            log.info("User has been deleted.");
        }
    }
}

package com.emlakcepte.controller;

import com.emlakcepte.request.RealtyRequest;
import com.emlakcepte.response.RealtyResponse;
import com.emlakcepte.service.RealtyService;
import com.emlakcepte.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/realties")
public class RealtyController {
    @Autowired
    private RealtyService realtyService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<RealtyResponse> getAll() {
        return realtyService.getAll();
    }

    @GetMapping(value = "/users/{id}")
    public List<RealtyResponse> getAllByUserId(@PathVariable Long id) {
        return realtyService.getAllByUserId(id);
    }

    @GetMapping(value = "/{id}")
    public RealtyResponse getById(@PathVariable Long id) {
        return realtyService.getById(id);
    }

    @GetMapping(value = "/users/actives/{userId}")
    public List<RealtyResponse> getAllByUserIdAndRealtyTypeActive(@PathVariable Long userId) {
        return realtyService.getAllByUserIdAndRealtyTypeActive(userId);
    }

    @GetMapping(value = "/users/passives/{userId}")
    public List<RealtyResponse> getAllByUserIdAndRealtyTypePassive(@PathVariable Long userId) {
        return realtyService.getAllByUserIdAndRealtyTypePassive(userId);
    }


    @PostMapping
    public RealtyResponse add(@RequestBody RealtyRequest realtyRequest) {
        return realtyService.add(realtyRequest);
    }
    @PostMapping(value ="/create" )
    public ResponseEntity<RealtyResponse> create(@RequestBody RealtyRequest realtyRequest) {
        RealtyResponse createdRealty = realtyService.create(realtyRequest);
        if (createdRealty != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRealty);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public RealtyResponse update(@RequestBody RealtyRequest realtyRequest) {
        return realtyService.update(realtyRequest);
    }

    @PutMapping(value = "/status/{id}")
    public RealtyResponse changeStatus(@PathVariable Long id) {
        return realtyService.isActiveOrIsPassive(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        realtyService.deleteById(id);
    }

}


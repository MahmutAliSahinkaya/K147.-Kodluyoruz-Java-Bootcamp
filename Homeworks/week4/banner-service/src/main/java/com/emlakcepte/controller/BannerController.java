package com.emlakcepte.controller;

import com.emlakcepte.request.BannerRequest;
import com.emlakcepte.response.BannerResponse;
import com.emlakcepte.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping(value = "/banners")
    public List<BannerResponse> getAll(){
        return bannerService.getAll();
    }

    @GetMapping(value = "/banners/{id}")
    public BannerResponse getById(@PathVariable Long id) {
        return bannerService.getById(id);
    }

    @PostMapping(value = "/banners")
    public BannerResponse add(@RequestBody BannerRequest bannerRequest) {
        return bannerService.add(bannerRequest);
    }

    @PutMapping(value = "/banners/{id}")
    public BannerResponse update(@RequestBody BannerRequest bannerRequest, @PathVariable Long id) {
        return bannerService.update(bannerRequest, id);
    }

    @DeleteMapping(value = "/banners/{id}")
    public void deleteById(@PathVariable Long id) {
        bannerService.deleteById(id);
    }

}

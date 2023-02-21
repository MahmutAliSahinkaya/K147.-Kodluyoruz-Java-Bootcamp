package com.emlakcepte.client;

import com.emlakcepte.request.BannerRequest;
import com.emlakcepte.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "banner-feign", url = "http://localhost:8081/banners")
public interface BannerClient {
    @PostMapping(value = "/banners")
    BannerResponse addBanner(@RequestBody BannerRequest bannerRequest);
}

package com.emlakcepte.converter;

import com.emlakcepte.model.Banner;
import com.emlakcepte.request.BannerRequest;
import com.emlakcepte.response.BannerResponse;
import org.springframework.stereotype.Component;


@Component
public class BannerConverter {
    private Long realtyNo = 123456789L;

    public BannerResponse convert(Banner banner) {
        BannerResponse bannerResponse = new BannerResponse();
        bannerResponse.setRealtyNo(banner.getRealtyNo());
        bannerResponse.setTitle(banner.getTitle());
        bannerResponse.setPhone(banner.getPhone());
        bannerResponse.setQuantity(banner.getQuantity());
        return bannerResponse;
    }

    public Banner convert(BannerRequest bannerRequest) {
        Banner banner = new Banner();
        banner.setRealtyNo(realtyNo++);
        banner.setTitle(bannerRequest.getTitle());
        banner.setPhone(bannerRequest.getPhone());
        banner.setQuantity(bannerRequest.getQuantity());
        return banner;
    }

}

package com.emlakcepte.service;

import com.emlakcepte.converter.BannerConverter;
import com.emlakcepte.model.Banner;
import com.emlakcepte.repository.BannerRepository;
import com.emlakcepte.request.BannerRequest;
import com.emlakcepte.response.BannerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private BannerConverter bannerConverter;

    public List<BannerResponse> getAll() {
        List<BannerResponse> bannerList = new ArrayList<>();
        for (Banner banner : bannerRepository.findAll()) {
            bannerList.add(bannerConverter.convert(banner));
        }
        log.info("Listed all banners.");
        return bannerList;
    }

    public BannerResponse getById(Long id) {
        return bannerConverter.convert(bannerRepository.getById(id));
    }

    public BannerResponse add(BannerRequest bannerRequest) {
        Banner banner = bannerConverter.convert(bannerRequest);
        log.info("Banner has been created.");
        return bannerConverter.convert(bannerRepository.save(banner));
    }

    public BannerResponse update(BannerRequest bannerRequest, Long id) {
        bannerRepository.getById(id);
        Banner banner = new Banner();
        banner.setId(id);
        banner.setRealtyNo(bannerRepository.getById(id).getRealtyNo());
        banner.setTitle(bannerRequest.getTitle());
        banner.setPhone(bannerRequest.getPhone());
        banner.setQuantity(bannerRequest.getQuantity());
        log.info("Banner has been updated.");
        return bannerConverter.convert(bannerRepository.save(banner));
    }

    public void deleteById(Long id) {
        getById(id);
        bannerRepository.deleteById(id);
        log.info("Banner has been deleted.");
    }

}

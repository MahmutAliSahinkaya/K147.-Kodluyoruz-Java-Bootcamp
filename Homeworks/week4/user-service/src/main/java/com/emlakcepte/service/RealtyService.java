package com.emlakcepte.service;

import com.emlakcepte.client.BannerClient;
import com.emlakcepte.converter.RealtyConverter;
import com.emlakcepte.model.Realty;
import com.emlakcepte.model.enums.RealtyType;
import com.emlakcepte.repository.RealtyRepository;
import com.emlakcepte.repository.UserRepository;
import com.emlakcepte.request.BannerRequest;
import com.emlakcepte.request.RealtyRequest;
import com.emlakcepte.response.RealtyResponse;
import com.emlakcepte.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RealtyService {
    @Autowired
    private RealtyRepository realtyRepository;
    @Autowired
    private RealtyConverter realtyConverter;
    @Autowired
    private BannerClient bannerClient;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    private static final int MAX_INDIVICUAL_REALTY_SIZE = 5;


    public List<RealtyResponse> getAll() {
        List<RealtyResponse> realtyList = new ArrayList<>();
        for (Realty realty : realtyRepository.findAll()) {
            realtyList.add(realtyConverter.convert(realty));
        }
        log.info("Listed all users.");
        return realtyList;
    }

    public List<RealtyResponse> getAllByUserIdAndRealtyTypeActive(Long userId) {
        List<RealtyResponse> activeList = new ArrayList<>();
        for (Realty realty : realtyRepository.findAllByUserIdAndRealtyType(userId, RealtyType.ACTIVE)) {
            activeList.add(realtyConverter.convert(realty));
        }
        return activeList;
    }

    public List<RealtyResponse> getAllByUserIdAndRealtyTypePassive(Long userId) {
        List<RealtyResponse> activeList = new ArrayList<>();
        for (Realty realty : realtyRepository.findAllByUserIdAndRealtyType(userId, RealtyType.PASSIVE)) {
            activeList.add(realtyConverter.convert(realty));
        }
        return activeList;
    }

    public List<RealtyResponse> getAllByUserId(Long id) {
        List<RealtyResponse> realtyList = new ArrayList<>();
        for (Realty realty : realtyRepository.getAllByUserId(id)) {
            realtyList.add(realtyConverter.convert(realty));
        }
        return realtyList;
    }

    public RealtyResponse getById(Long id) {
        return realtyConverter.convert(realtyRepository.getById(id));
    }

    public RealtyResponse add(RealtyRequest realtyRequest) {
        if (userService.getById(realtyRequest.getUserId()) == null) {
           if (userService.getIdIfQuantityExist(realtyRequest.getUserId()) != null) {
        Realty realty = realtyConverter.convert(realtyRequest);
               BannerRequest bannerRequest = new BannerRequest();
                bannerRequest.setRealtyNo(realtyRequest.getRealtyNo());
                bannerRequest.setTitle(realtyRequest.getTitle());
               bannerClient.addBanner(bannerRequest);
        Realty realty2 = realtyRepository.save(realty);
        log.info("Realty has been created.");
        return realtyConverter.convert(realty2);
            } else {
                log.info("User has not enough quantity!");
                System.out.println("User has not enough quantity!");
           }
        } else {
            log.info("User ID not found!");
            System.out.println("User not found!");

        }
        return null;
    }

    public RealtyResponse create(RealtyRequest realtyRequest) {
        UserResponse userResponse = userService.getById(realtyRequest.getUserId());
        if (userResponse != null) {
            userResponse = (UserResponse) userService.getIdIfQuantityExist(realtyRequest.getUserId());
            if (userResponse != null) {
                Realty realty = realtyConverter.convert(realtyRequest);
                Realty savedRealty = realtyRepository.save(realty);
                BannerRequest bannerRequest = new BannerRequest();
                bannerRequest.setRealtyNo(realtyRequest.getRealtyNo());
                bannerRequest.setTitle(realtyRequest.getTitle());
                bannerClient.addBanner(bannerRequest);
                return realtyConverter.convert(savedRealty);
            }
        }

        return null;
    }


    public RealtyResponse update(RealtyRequest realtyRequest) {
        realtyRepository.findById(realtyRequest.getUserId());
        Realty realty = new Realty();
        realty.setRealtyType(realtyRequest.getRealtyType());
        realty.setTitle(realtyRequest.getTitle());
        log.info("Realty has been updated!");
        return realtyConverter.convert(realtyRepository.save(realty));
    }


    public void deleteById(Long id) {
        getById(id);
        realtyRepository.deleteById(id);
        log.info("Realty has been deleted.");
    }

    public void changeStatus(Long id) {
        Realty realty = realtyRepository.getById(id);
        realty.setRealtyType(RealtyType.ACTIVE);
        log.info("Realty status has been changed to " + realty.getRealtyType());
        realtyRepository.save(realty);
    }

    public RealtyResponse isActiveOrIsPassive(Long id) {
        Realty realty = realtyRepository.getById(id);
        if (realty.getRealtyType().equals(RealtyType.ACTIVE)) {
            realty.setRealtyType(RealtyType.PASSIVE);
        } else {
            realty.setRealtyType(RealtyType.ACTIVE);
        }
        return realtyConverter.convert(realtyRepository.save(realty));
    }


}

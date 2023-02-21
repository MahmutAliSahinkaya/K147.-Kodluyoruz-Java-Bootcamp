package com.emlakcepte.converter;

import com.emlakcepte.model.Realty;
import com.emlakcepte.request.RealtyRequest;
import com.emlakcepte.response.RealtyResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RealtyConverter {
    private Long realtyNo = 12345678L;
    private Date date = new Date();

    public RealtyResponse convert(Realty realty) {
        RealtyResponse realtyResponse = new RealtyResponse();
        realtyResponse.setId(realty.getId());
        realtyResponse.setRealtyNo(realtyNo);
        realtyResponse.setRealtyType(realty.getRealtyType());
        realtyResponse.setTitle(realty.getTitle());
        realtyResponse.setProvince(realty.getProvince());
        realtyResponse.setDistrict(realty.getDistrict());
        realtyResponse.setCreatedDate(date);
        return realtyResponse;
    }
    public Realty convert(RealtyRequest realtyRequest) {
        Realty realty = new Realty();
        realty.setRealtyNo(realtyNo++);
        realty.setRealtyType(realtyRequest.getRealtyType());
        realty.setTitle(realtyRequest.getTitle());
        return realty;
    }
    public List<RealtyResponse> convert(List<Realty> realtyList) {
        List<RealtyResponse> realtyResponse = new ArrayList<>();

        for (Realty realty : realtyList) {
            realtyResponse.add(convert(realty));
        }
        return realtyList.stream().map(this::convert).toList();
    }
}

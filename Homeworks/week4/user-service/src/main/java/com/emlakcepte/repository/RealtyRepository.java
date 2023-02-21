package com.emlakcepte.repository;

import com.emlakcepte.model.Realty;
import com.emlakcepte.model.enums.RealtyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealtyRepository extends JpaRepository<Realty,Long> {
    List<Realty> getAllByUserId(Long id);
    List<Realty> findAllByUserIdAndRealtyType(Long userId, RealtyType realtyType);

}

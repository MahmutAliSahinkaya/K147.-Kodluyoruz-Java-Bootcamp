package com.emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emlakcepte.model.Realty;
import com.emlakcepte.service.RealtyService;

@RestController
@RequestMapping("/realties")
public class RealtyController {

	@Autowired
	private final RealtyService realtyService;

	public RealtyController(RealtyService realtyService) {
		this.realtyService = realtyService;
	}

	@PostMapping("/realties")
	public void createRealty(@RequestBody Realty realty) {
		realtyService.createRealty(realty);
	}

	@GetMapping("/realties")
	public List<Realty> getAllRealties() {
		return realtyService.getAllRealties();
	}

	@PutMapping("/realties/{no}")
	public Realty updateRealty(@PathVariable Long no, @RequestBody Realty realty) {
		return realtyService.updateRealty(realty, realty.getTitle(), realty.getStatus(), realty.getEstateType(),
				realty.getSalesType());
	}

	@GetMapping("/realties/{no}")
	public Realty getRealtyByNo(@PathVariable Long no) {
		return realtyService.getRealtyByNo(no);
	}

	@GetMapping("/realties/province/{province}/district/{district}")
	public List<Realty> getAllByProvinceAndDistrict(@PathVariable String province, @PathVariable String district) {
		return realtyService.getAllByProvinceAndDistrict(province, district);
	}

	@GetMapping("/realties/province/{province}")
	public List<Realty> showcaseProvince(@PathVariable String province) {
		return realtyService.showcaseProvince(province);
	}

}

package com.emlakcepte.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.model.enums.EstateType;
import com.emlakcepte.model.enums.RealtyType;
import com.emlakcepte.model.enums.SalesType;
import com.emlakcepte.model.enums.UserType;
import com.emlakcepte.repository.RealtyRepository;

@Service
public class RealtyService {

	@Autowired
	private final RealtyRepository realtyRepository;

	public RealtyService(RealtyRepository realtyRepository) {
		this.realtyRepository = realtyRepository;
	}

	@Autowired // injection
	private UserService userService;

	// bireysel kullanıcılar "sadece konut tipinde" 3 ilan girebilir.

	public void createRealty(Realty realty) {
		int maxRealtyCount = 3;
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			if ((EstateType.HOUSE.equals(realty.getUser().getType())) && (maxRealtyCount != 0)) {
				realtyRepository.save(realty);
				System.out.println("createRealty :: " + realty.getTitle());
				maxRealtyCount--;
			} else {
				System.out.println("Bireysel kullanıclar en fazla 3 ilan girebilir.");
			}
			realtyRepository.save(realty);
			System.out.println("createRealty :: " + realty.getTitle());
		}

	}

	// tüm ilanları gösterme

	public List<Realty> getAllRealties() {
		return realtyRepository.findAll();
	}

	public Realty updateRealty(Realty realty, String title, RealtyType status, EstateType estateType,
			SalesType salesType) {
		realty.setTitle(title);
		realty.setStatus(status);
		realty.setEstateType(estateType);
		realty.setSalesType(salesType);
		realtyRepository.save(realty);
		return realty;

	}

	public void deleteRealty(Realty realty) {
		realtyRepository.delete(realty);
	}

	public Realty getRealtyByNo(Long no) {
		return realtyRepository.findByNo(no);
	}

	// Kullanıcının girmiş olduğu il ve ilçe bilgisine göre ilanları gösterme
	public List<Realty> getAllByProvinceAndDistrict(String province, String district) {
		List<Realty> result = new ArrayList<>();
		List<Realty> allRealties = getAllRealties();
		for (Realty realty : allRealties) {
			if (realty.getProvince().equalsIgnoreCase(province) && realty.getDistrict().equalsIgnoreCase(district)) {
				result.add(realty);
			}
		}
		return result;
	}

	// şehir vitrini

	public List<Realty> showcaseProvince(String province) {
		List<Realty> result = new ArrayList<>();
		List<Realty> allRealties = getAllRealties();
		for (Realty realty : allRealties) {
			if (realty.getProvince().equalsIgnoreCase(province)) {
				result.add(realty);
				if (result.size() == 10) {
					break;
				}
			}
		}
		return result;
	}

	// şehir bazlı ilan arama

	public List<Realty> getRealtiesByProvince(String province) {
		List<Realty> result = new ArrayList<>();
		for (Realty realty : getAllRealties()) {
			if (realty.getProvince().equals(province)) {
				result.add(realty);
			}
		}
		return result;
	}

//Bu, tüm "Realty" nesnelerini bir döngü içinde dolaşır ve "province" alanı ile verilen "province" değişkenine eşit olanları sayar. Daha sonra bu sayıyı ekrana yazar.
	public void getRealtyCountByProvince(String province) {
		int count = 0;
		for (Realty realty : getAllRealties()) {
			if (realty.getProvince().equals(province)) {
				count++;
			}
		}
		System.out.println(province + " şehrindeki ilanların sayısı = " + count);
	}

//Bu, tüm "Realty" nesnelerini bir döngü içinde dolaşır ve "province", "estateType" ve "salesType" alanları ile verilen değişkenlerine eşit olanları sayar. Daha sonra bu sayıyı ekrana yazar.
	public void getRealtyCountByProvinceAndType(String province, EstateType estateType, SalesType salesType) {
		int count = 0;
		for (Realty realty : getAllRealties()) {
			if (realty.getProvince().equals(province) && realty.getEstateType().equals(estateType)
					&& realty.getSalesType().equals(salesType)) {
				count++;
			}
		}
		System.out.println(province + " şehrindeki " + salesType + " " + estateType + " ilanlarının sayısı = " + count);
	}

	// şehir ve ilçe bazlı ilan arama

	public void getRealtiesByProvinceAndDistrict(String province, String district) {
		for (Realty realty : getAllRealties()) {
			if (realty.getProvince().equals(province) && realty.getDistrict().equals(district)) {
				System.out.println(realty);
			}
		}
	}

	public List<Realty> getAllByUserName(User user) {
		return getAllRealties().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(@PathVariable User user) {

		return getAllRealties().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}

}

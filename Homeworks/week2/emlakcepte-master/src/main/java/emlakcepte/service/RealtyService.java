package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.EstateType;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.SalesType;
import emlakcepte.model.Search;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {

	private RealtyDao realtyDao = new RealtyDao();

	@Autowired // injection
	private UserService userService;

	// bireysel kullanıcılar "sadece konut tipinde" 3 ilan girebilir.
	public void createRealty(Realty realty) {
		// userService.printAllUser();
		int maxRealtyCount = 3;
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			if ((EstateType.HOUSE.equals(realty.getUser().getType())) && (maxRealtyCount != 0)) {
				realtyDao.saveRealty(realty);
				System.out.println("createRealty :: " + realty.getTitle());
				maxRealtyCount--;
			} else {
				System.out.println("Bireysel kullanıclar en fazla 3 ilan girebilir.");
			}
			realtyDao.saveRealty(realty);
			System.out.println("createRealty :: " + realty.getTitle());
		}

	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	// tüm ilanları gösterme
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void cityShowcase(List<Realty> showcase) {
		getAll().stream().filter(realty -> realty.getProvince().equals(showcase))
				.forEach(realty -> System.out.println(realty));
	}

	// şehir bazlı ilan arama
	public void getAllByProvince(String province) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				// .count();
				.forEach(realty -> System.out.println(realty));
	}

	public void getAllByCountProvince(String province) {

		long total = getAll().stream().filter(realty -> realty.getProvince().equals(province)).count();
		System.out.println(province + " şehrindeki ilanların sayısı = " + total);
	}

	// (2. hafta ödevinin 7. sorusunun 6. maddesi) Kullanıcının girmiş olduğu il,
	// satış ve konut tipi bilgilerine göre ilan sayılarını ekrana bastıran method.
	public void getByProvinceAndSalesType(String province, EstateType estateType, SalesType salesType) {
		long total = getAll()
				.stream().filter(realty -> realty.getProvince().equals(province)
						&& (realty.getEstateType().equals(estateType)) && (realty.getSalesType().equals(salesType)))
				.count();
		System.out.println(province + " şehrindeki " + salesType + " " + estateType + " ilanlarının sayısı = " + total);
	}

	// şehir ve ilçe bazlı ilan arama
	public void getByProvinceAndDistrict(String province, String district) {
		getAll().stream().forEach(realty -> System.out.println(realty));
	}

	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	// (2. hafta ödevinin 7. sorusunun 1. maddesi) Kullanıcının girmiş olduğu il ve
	// ilçe bilgilerini ekrana bastıran method.
	public void getAllByProvinceAndDistrict(String province, String district) {
		getAll().stream().filter(
				(realty -> ((realty.getProvince().equals(province)) && (realty.getDistrict().equals(district)))))
				.forEach(realty -> System.out.println(realty));
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}

	public List<Realty> searchRealty(Search search) {
		List<Realty> realties = realtyDao.findAll();

		if (realtyDao.findAll() != null) {

		}

		return realties;
	}

}

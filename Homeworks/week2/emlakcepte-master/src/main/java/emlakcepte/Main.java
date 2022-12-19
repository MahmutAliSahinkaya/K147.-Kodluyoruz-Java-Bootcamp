package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emlakcepte.model.EstateType;
import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.SalesType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());

		UserService userService = UserService.getSameInstance();
		UserService userService1 = UserService.getSameInstance();

		UserService userService2 = UserService.getDifferentInstance();

		System.out.println(userService);
		System.out.println(userService1);
		System.out.println(userService2);

		userService.createUser(userPelin);
		userService1.createUser(userSami);

		userService.printAllUser();

		System.out.println("-----");

		RealtyService realtyService = new RealtyService();

		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
				RealtyType.ACTIVE, EstateType.HOUSE, SalesType.FOR_SALE);
		realty.setProvince("İstanbul");
		realty.setDistrict("Maltepe");
		realtyService.createRealty(realty);

		Realty realty1 = new Realty();
		realty1.setNo(124L);
		realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
		realty1.setStatus(RealtyType.ACTIVE);
		realty1.setUser(userPelin);
		realty1.setProvince("İstanbul");
		realty1.setDistrict("Maltepe");
		realty1.setEstateType(EstateType.HOUSE);
		realty1.setSalesType(SalesType.FOR_SALE);

		realtyService.createRealty(realty1);

		Realty favori1 = new Realty();
		favori1.setNo(125L);
		favori1.setTitle("KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI");
		favori1.setStatus(RealtyType.ACTIVE);
		favori1.setUser(userPelin);
		favori1.setProvince("Ankara");
		favori1.setDistrict("Çankaya");
		favori1.setEstateType(EstateType.HOUSE);
		favori1.setSalesType(SalesType.FOR_SALE);

		realtyService.createRealty(favori1);

		realty.setUser(userSami);
		userSami.setRealtyList(List.of(realty, realty1));

		List<Realty> fovarilerim = new ArrayList<>();
		fovarilerim.add(favori1);
		userSami.setFavoriteRealtyList(fovarilerim);

		// sistemdeki bütün ilanlar

		System.out.println("Bütün ilanlar");

		realtyService.printAll(realtyService.getAll());

		// İstanbuldaki ilanların bulunması

		System.out.println("İstanbul'daki ilanlar");

		realtyService.getAllByProvince("İstanbul");

		// Bir kullanıcının bütün ilanlarını listele
		realtyService.printAll(realtyService.getAllByUserName(userPelin));

		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		// (2. hafta ödevinin 7. sorusunun 1. maddesi) Kullanıcının girmiş olduğu il ve
		// ilçe bilgilerini ekrana bastıran method.
		realtyService.getAllByProvinceAndDistrict("İstanbul", "Maltepe");

		// 7. sorunun 5. maddesi

		// İstanbul Şehrindeki ilanların sayısı
		realtyService.getAllByCountProvince("İstanbul");
		// Ankara Şehrindeki ilanların sayısı
		realtyService.getAllByCountProvince("Ankara");
		// İzmir Şehrindeki ilanların sayısı
		realtyService.getAllByCountProvince("İzmir");

		// (2. hafta ödevinin 7. sorusunun 6. maddesi)
		// Kullanıcının girmiş olduğu il, satış ve konut tipi bilgilerine göre ilan
		// sayılarını ekrana bastıran method.

		// İstanbul şehrindeki satılık konut ilanlarının sayısı
		realtyService.getByProvinceAndSalesType("İstanbul", EstateType.HOUSE, SalesType.FOR_SALE);
		// Ankara şehrindeki satılık konut ilanlarının sayısı
		realtyService.getByProvinceAndSalesType("Ankara", EstateType.HOUSE, SalesType.FOR_SALE);
		// İzmir şehrindeki satılık konut ilanlarının sayısı
		realtyService.getByProvinceAndSalesType("İzmir", EstateType.HOUSE, SalesType.FOR_SALE);

		Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);

		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));

		userSami.getMessages();

		// 10 ilandan oluşan şehir bazlı şehir vitrini
		// örnek olarak İstanbul ili verilmiştir.
		List<Realty> cityShowcase = new ArrayList<Realty>(10);
		for (int i = 0; i < 10; i++) {
			realtyService.getAllByProvince("İstanbul");
		}

	}

	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		return user;
	}

}

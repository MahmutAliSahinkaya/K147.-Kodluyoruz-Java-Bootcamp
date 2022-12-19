package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import emlakcepte.model.Realty;

public class SearchService {

	List<Realty> searches = new ArrayList<>();

	public void add(Realty realty) {
		searches.add(realty);
	}

	public List<Realty> getAll() {
		return searches;
	}

	// şehir ve ilçe bazlı arama yapıyor ve arama sonucu null değilse arama kayıt
	// ediliyor.
	public Realty getByProvince(String province, String district) {
		for (Realty realty : searches) {
			if (Objects.equals(realty.getProvince(), realty.getDistrict())) {
				searches.add(realty);
				return realty;
			}
		}
		return null;
	}

}

package emlakcepte.model;

import java.util.ArrayList;
import java.util.List;

public class CityShowcase {
	private String province;
	private Realty realty;

	List<Realty> cityShowcase = new ArrayList<Realty>(10);

	public CityShowcase() {
		super();
	}

	public CityShowcase(String province, Realty realty, List<Realty> cityShowcase) {
		super();
		this.province = province;
		this.realty = realty;
		this.cityShowcase = cityShowcase;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Realty getRealty() {
		return realty;
	}

	public void setRealty(Realty realty) {
		this.realty = realty;
	}

	public List<Realty> getCityShowcase() {
		return cityShowcase;
	}

	public void setCityShowcase(List<Realty> cityShowcase) {
		this.cityShowcase = cityShowcase;
	}

}

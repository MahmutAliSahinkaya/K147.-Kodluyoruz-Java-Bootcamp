package emlakcepte.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Realty {

	private Long no;
	private String title;
	private LocalDateTime publishedDate;
	private User user;
	private RealtyType status;
	private SalesType salesType;
	private EstateType estateType;
	private String province;
	private String district;
	private List<Realty> cityShowcase = new ArrayList<Realty>(10);

	public Realty() {
		super();
	}

	public Realty(Long no, String title, LocalDateTime publishedDate, User user, RealtyType status,
			EstateType estateType, SalesType salesType) {
		super();
		this.no = no;
		this.title = title;
		this.publishedDate = publishedDate;
		this.user = user;
		this.status = status;
		this.salesType = salesType;
		this.estateType = estateType;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RealtyType getStatus() {
		return status;
	}

	public void setStatus(RealtyType status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public SalesType getSalesType() {
		return salesType;
	}

	public void setSalesType(SalesType salesType) {
		this.salesType = salesType;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public void setEstateType(EstateType estateType) {
		this.estateType = estateType;
	}

	public List<Realty> getCityShowcase() {
		return cityShowcase;
	}

	public void setCityShowcase(List<Realty> cityShowcase) {
		this.cityShowcase = cityShowcase;
	}

	@Override
	public String toString() {
		return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
				+ ", status=" + getStatus() + ", province=" + province + ", district=" + district + "]";
	}

}

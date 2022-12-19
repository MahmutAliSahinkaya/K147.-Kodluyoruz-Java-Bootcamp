package emlakcepte.model;

public class Search {
	private String id;
	private String filter;

	private User user;
	private Realty realty;

	public Search() {
		super();
	}

	public Search(User user, String filter) {
		this.id = id;
		this.user = user;
		this.filter = filter;
		user.getSavedSearches().add(realty);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Realty getRealty() {
		return realty;
	}

	public void setRealty(Realty realty) {
		this.realty = realty;
	}

	@Override
	public String toString() {
		return "Search [id=" + id + ", filter=" + filter + ", user=" + user.getName() + ", realty=" + realty + "]";
	}

}

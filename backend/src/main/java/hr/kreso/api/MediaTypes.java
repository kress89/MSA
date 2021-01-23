package hr.kreso.api;

public enum MediaTypes {
	MOVIE(1), SHOW(2);

	private int id;

	MediaTypes(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

package hr.kreso.api.model;

public class Media {
	private Integer id;
	private String naziv;
	private String opis;
	private String dodaci;
	private MediaType tip;
	private MediaSource izvor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDodaci() {
		return dodaci;
	}

	public void setDodaci(String dodaci) {
		this.dodaci = dodaci;
	}

	public MediaType getTip() {
		return tip;
	}

	public void setTip(MediaType tip) {
		this.tip = tip;
	}

	public MediaSource getIzvor() {
		return izvor;
	}

	public void setIzvor(MediaSource izvor) {
		this.izvor = izvor;
	}
}

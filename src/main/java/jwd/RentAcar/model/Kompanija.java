package jwd.RentAcar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblKompanija")
public class Kompanija {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "adresa")
	private String adresa;
	@Column(name = "telefon")
	private String telefon;
	@OneToMany(mappedBy="kompanija", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Automobil> automobili= new ArrayList<>();

	public Kompanija() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Automobil> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(List<Automobil> automobili) {
		this.automobili = automobili;
	}
	public void addAutomobil(Automobil automobil){
		this.automobili.add(automobil);
		if(automobil.getKompanija()!=null && !automobil.getKompanija().equals(this)){
			automobil.setKompanija(this);
		}
	}

}

package jwd.RentAcar.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "tblAutomobil")
public class Automobil {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "model", nullable=false)
	private String model;
	@Column(name = "registracija" ,nullable=false, unique=true)
	private String registracija;
	@Column(name = "godiste", nullable=false)
	private Integer godiste;
	@Column(name = "potrosnja")
	private Double potrosnja;
	@Column(name = "iznajmljen")
	private Boolean iznajmljen = false;
	@ManyToOne(fetch = FetchType.EAGER)
	private Kompanija kompanija;
	
	public Automobil() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistracija() {
		return registracija;
	}
	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}
	public Integer getGodiste() {
		return godiste;
	}
	public void setGodiste(Integer godiste) {
		this.godiste = godiste;
	}
	public Double getPotrosnja() {
		return potrosnja;
	}
	public void setPotrosnja(Double potrosnja) {
		this.potrosnja = potrosnja;
	}
	public Boolean getIznajmljen() {
		return iznajmljen;
	}
	public void setIznajmljen(Boolean iznajmljen) {
		this.iznajmljen = iznajmljen;
	}
	public Kompanija getKompanija() {
		return kompanija;
	}
	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
		if (!kompanija.getAutomobili().contains(this)) {
			kompanija.getAutomobili().add(this);
		}
	}
	public boolean isIznajmljen() {
		// TODO Auto-generated method stub
		return iznajmljen;
	}
	
	
}

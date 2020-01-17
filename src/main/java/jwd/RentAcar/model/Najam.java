package jwd.RentAcar.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tblNajam")
public class Najam {
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	private Automobil automobil;

	public Najam() {
		super();
	}

	public Automobil getAutomobil() {
		return automobil;
	}
	
	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

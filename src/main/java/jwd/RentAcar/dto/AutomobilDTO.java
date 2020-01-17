package jwd.RentAcar.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AutomobilDTO {
	private Long id;
	@NotEmpty
	@NotNull
	private String model;

	private String registracija;
	@Max(9999)
	private Integer godiste;
	@Max(99)
	private Double potrosnja;
	
	private Boolean iznajmljen = false;

	private Long kompanijaId;

	private String kompanijaName;

	public AutomobilDTO() {
		super();
	}

	public Long getKompanijaId() {
		return kompanijaId;
	}

	public void setKompanijaId(Long kompanijaId) {
		this.kompanijaId = kompanijaId;
	}

	public String getKompanijaName() {
		return kompanijaName;
	}

	public void setKompanijaName(String kompanijaName) {
		this.kompanijaName = kompanijaName;
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

}

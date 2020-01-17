package jwd.RentAcar.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.RentAcar.dto.AutomobilDTO;
import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Kompanija;
import jwd.RentAcar.service.AutomobiliService;
import jwd.RentAcar.service.KompanijaService;

@Component
public class AutomobilDTOtoAutomobil implements Converter<AutomobilDTO, Automobil>{

	@Autowired
	private AutomobiliService autoService;
	
	@Autowired
	private KompanijaService kompanijaService;

	@Override
	public Automobil convert(AutomobilDTO automobilDTO) {
		Kompanija kompanija = kompanijaService.findOne(automobilDTO.getKompanijaId());

		if (kompanija != null) {

			Automobil auto = null;

			if (automobilDTO.getId() != null) {
				auto = autoService.findOne(automobilDTO.getId());
			} else {
				auto = new Automobil();
			}

			auto.setId(automobilDTO.getId());
			auto.setGodiste(automobilDTO.getGodiste());
			auto.setModel(automobilDTO.getModel());
			auto.setRegistracija(automobilDTO.getRegistracija());
			auto.setPotrosnja(automobilDTO.getPotrosnja());
			auto.setIznajmljen(automobilDTO.getIznajmljen());
			auto.setKompanija(kompanija);

			return auto;
		} else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}		
	}
	
	public List<Automobil> convert(List<AutomobilDTO> automobiliDTO) {
		List<Automobil> ret = new ArrayList<>();

		for (AutomobilDTO autoDTO : automobiliDTO) {
			ret.add(convert(autoDTO));
		}

		return ret;
	}
}

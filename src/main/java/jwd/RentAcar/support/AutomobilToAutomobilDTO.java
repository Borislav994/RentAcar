package jwd.RentAcar.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.RentAcar.dto.AutomobilDTO;
import jwd.RentAcar.model.Automobil;

@Component
public class AutomobilToAutomobilDTO implements Converter<Automobil, AutomobilDTO> {

	@Override
	public AutomobilDTO convert(Automobil automobil) {
		AutomobilDTO retValue = new AutomobilDTO();
		retValue.setId(automobil.getId());
		retValue.setModel(automobil.getModel());
		retValue.setRegistracija(automobil.getRegistracija());
		retValue.setGodiste(automobil.getGodiste());
		retValue.setPotrosnja(automobil.getPotrosnja());
		retValue.setIznajmljen(automobil.getIznajmljen());
		retValue.setKompanijaId(automobil.getKompanija().getId());
		retValue.setKompanijaName(automobil.getKompanija().getNaziv());
		
		return retValue;
	}
	
	public List<AutomobilDTO> convert(List<Automobil> automobili) {
		List<AutomobilDTO> ret = new ArrayList<>();

		for (Automobil automobil : automobili) {
			ret.add(convert(automobil));
		}

		return ret;
	}

}

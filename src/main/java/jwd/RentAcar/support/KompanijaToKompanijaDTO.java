package jwd.RentAcar.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.RentAcar.dto.KompanijaDTO;
import jwd.RentAcar.model.Kompanija;

@Component
public class KompanijaToKompanijaDTO implements Converter<Kompanija, KompanijaDTO> {

	@Override
	public KompanijaDTO convert(Kompanija kompanija) {
		KompanijaDTO retValue = new KompanijaDTO();
		retValue.setId(kompanija.getId());
		retValue.setNaziv(kompanija.getNaziv());
		retValue.setAdresa(kompanija.getAdresa());
		retValue.setTelefon(kompanija.getTelefon());
		
		return retValue;
	}
	
	public List<KompanijaDTO> convert(List<Kompanija> kopanije) {
		List<KompanijaDTO> ret = new ArrayList<>();

		for (Kompanija kompanija : kopanije) {
			ret.add(convert(kompanija));
		}

		return ret;
	}

}

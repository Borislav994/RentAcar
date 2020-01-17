package jwd.RentAcar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Kompanija;
import jwd.RentAcar.service.AutomobiliService;
import jwd.RentAcar.service.KompanijaService;

@Component
public class TestData {
	
	@Autowired
	private KompanijaService kompanijaService;
	
	@Autowired
	private AutomobiliService autoService;
	
	@PostConstruct
	public void init() {
		
		Kompanija k1 = new Kompanija();
		k1.setAdresa("Lenjinova 45");
		k1.setNaziv("SpasicCAR");
		k1.setTelefon("0652282815");
		
		kompanijaService.save(k1);
		
		Kompanija k2 = new Kompanija();
		k2.setAdresa("Save Dimitrijevica 65");
		k2.setNaziv("DimitrijevicCAR");
		k2.setTelefon("0655282815");
		
		kompanijaService.save(k2);
		
		Automobil a1 = new Automobil();
		a1.setModel("Pegout 607");
		a1.setRegistracija("NS333MR");
		a1.setGodiste(2009);
		a1.setPotrosnja(6.5);
		a1.setIznajmljen(false);
		a1.setKompanija(k1);
		
		autoService.save(a1);
		
		Automobil a2 = new Automobil();
		a2.setModel("Pegout 307");
		a2.setRegistracija("BG333MR");
		a2.setGodiste(2018);
		a2.setPotrosnja(7.5);
		a2.setIznajmljen(false);
		a2.setKompanija(k2);
		
		autoService.save(a2);
		
		
		
	}

}

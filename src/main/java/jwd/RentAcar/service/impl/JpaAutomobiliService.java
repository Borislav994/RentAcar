package jwd.RentAcar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Najam;
import jwd.RentAcar.repository.AutomobilRepository;
import jwd.RentAcar.repository.NajamRepository;
import jwd.RentAcar.service.AutomobiliService;

@Service
public class JpaAutomobiliService implements AutomobiliService {
	
	@Autowired
	private AutomobilRepository autoRepository;
	
	@Autowired
	private NajamRepository najamRepository;

	@Override
	public Automobil findOne(Long id) {
		// TODO Auto-generated method stub
		return autoRepository.findOne(id);
	}

	@Override
	public Page<Automobil> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return autoRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Automobil save(Automobil automobil) {
		// TODO Auto-generated method stub
		return autoRepository.save(automobil);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autoRepository.delete(id);
	}

	@Override
	public List<Automobil> findByMagacin(Long kompanijaId) {
		// TODO Auto-generated method stub
		return autoRepository.findByKompanijaId(kompanijaId);
	}

	@Override
	public Page<Automobil> search(String model, Integer godiste, Double potrosnja, int pageNum) {
		if(model != null) {
			model = '%' + model + '%';
		}
		
		return autoRepository.search(model, godiste, potrosnja, new PageRequest(pageNum, 5));
	}

	@Override
	public Najam iznajmi(Long id) {
		// TODO Auto-generated method stub
Automobil a = findOne(id);
		
		if(a != null) {
			Najam n = null;
			if(!a.isIznajmljen()) {
				n = new Najam();
				n.setAutomobil(a);
				najamRepository.save(n);
				
				a.setIznajmljen(true);
				autoRepository.save(a);
			}
			
			return n;
		}
		else {
			throw new IllegalArgumentException("Pukusali ste da iznajmite nepostojeci automobil!");
		}
	}

}

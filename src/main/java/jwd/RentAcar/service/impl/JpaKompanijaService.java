package jwd.RentAcar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.RentAcar.model.Kompanija;
import jwd.RentAcar.repository.KompanijaRepository;
import jwd.RentAcar.service.KompanijaService;

@Service
@Transactional
public class JpaKompanijaService implements KompanijaService  {
	
	@Autowired
	private KompanijaRepository kompanijaRepository;

	@Override
	public List<Kompanija> findAll() {
		// TODO Auto-generated method stub
		return kompanijaRepository.findAll();
	}

	@Override
	public Kompanija findOne(Long id) {
		// TODO Auto-generated method stub
		return kompanijaRepository.findOne(id);
	}

	@Override
	public Kompanija save(Kompanija kompanija) {
		// TODO Auto-generated method stub
		return kompanijaRepository.save(kompanija);
	}

}

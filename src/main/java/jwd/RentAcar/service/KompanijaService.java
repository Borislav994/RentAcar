package jwd.RentAcar.service;

import java.util.List;

import jwd.RentAcar.model.Kompanija;

public interface KompanijaService {

	List<Kompanija> findAll();

	Kompanija findOne(Long id);
	
	Kompanija save(Kompanija kompanija);
}

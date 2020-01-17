package jwd.RentAcar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Najam;

public interface AutomobiliService {

	Automobil findOne(Long id);

	Page<Automobil> findAll(int pageNum);

	Automobil save(Automobil automobil);

	void delete(Long id);

	List<Automobil> findByMagacin(Long kompanijaId);
	
	Page<Automobil> search(
			@Param("model") String model, 
			@Param("donja") Integer godiste,
			@Param("gornja") Double potrosnja,
			int pageNum);
	
	Najam iznajmi(Long id);
}

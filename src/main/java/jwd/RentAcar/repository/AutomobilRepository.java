package jwd.RentAcar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.RentAcar.model.Automobil;


@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long > {
	List<Automobil> findByKompanijaId(Long kompanijaId);
	
	@Query("SELECT a FROM Automobil a WHERE "
			+ "(:model IS NULL or a.model like :model) AND "
			+ "(:godiste IS NULL OR a.godiste >= :godiste) AND "
			+ "(:potrosnja IS NULL OR a.potrosnja <= :potrosnja)"
			)
	Page<Automobil> search(
			@Param("model") String model, 
			@Param("godiste") Integer godiste,
			@Param("potrosnja") Double potrosnja,
			Pageable pageRequest);
}

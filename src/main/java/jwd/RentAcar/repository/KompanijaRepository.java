package jwd.RentAcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.RentAcar.model.Kompanija;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Long>  {

}

package jwd.RentAcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.RentAcar.model.Najam;

@Repository
public interface NajamRepository extends JpaRepository<Najam, Long >{

}

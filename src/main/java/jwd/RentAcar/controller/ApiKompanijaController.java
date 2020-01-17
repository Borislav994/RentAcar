package jwd.RentAcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.RentAcar.dto.AutomobilDTO;
import jwd.RentAcar.dto.KompanijaDTO;
import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Kompanija;
import jwd.RentAcar.service.AutomobiliService;
import jwd.RentAcar.service.KompanijaService;
import jwd.RentAcar.support.AutomobilToAutomobilDTO;
import jwd.RentAcar.support.KompanijaToKompanijaDTO;


@RestController
@RequestMapping("/api/kompanije")
public class ApiKompanijaController {

	@Autowired
	private KompanijaService kompanijaService;
	
	@Autowired
	private AutomobiliService autoService;
	
	@Autowired
	private KompanijaToKompanijaDTO toDTO;
	
	@Autowired
	private AutomobilToAutomobilDTO toDTOa;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KompanijaDTO>> getActivities(){
		
		List<Kompanija> kompanije = kompanijaService.findAll();
		
		return new ResponseEntity<>(toDTO.convert(kompanije), HttpStatus.OK);
	} 
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<KompanijaDTO> getOne(@PathVariable Long id) {
		Kompanija ac = kompanijaService.findOne(id);
		if (ac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(ac), HttpStatus.OK);
	}
	
	@RequestMapping(value = "{kompanijaId}/automobili", method = RequestMethod.GET)
	public ResponseEntity<List<AutomobilDTO>> getAllId(@PathVariable Long kompanijaId){
		List<Automobil> auto = autoService.findByMagacin(kompanijaId);

		return new ResponseEntity<>(toDTOa.convert(auto), HttpStatus.OK);
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

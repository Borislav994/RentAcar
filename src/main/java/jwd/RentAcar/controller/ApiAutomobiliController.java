package jwd.RentAcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.RentAcar.dto.AutomobilDTO;
import jwd.RentAcar.model.Automobil;
import jwd.RentAcar.model.Najam;
import jwd.RentAcar.service.AutomobiliService;
import jwd.RentAcar.support.AutomobilDTOtoAutomobil;
import jwd.RentAcar.support.AutomobilToAutomobilDTO;

@Controller
@RequestMapping("/api/automobili")
public class ApiAutomobiliController {
	
	@Autowired
	private AutomobiliService autoService;
	
	@Autowired
	private AutomobilDTOtoAutomobil toAuto;
	
	@Autowired
	private AutomobilToAutomobilDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AutomobilDTO>> get(
			@RequestParam(required = false) String model,
			@RequestParam(required = false) Integer godiste,
			@RequestParam(required = false) Double potrosnja,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum
			) {

		Page<Automobil> recordsPage = null;

		if (model != null || godiste != null || potrosnja != null ) {
			recordsPage = autoService.search(model, godiste, potrosnja, pageNum);
		} else {
			recordsPage = autoService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(recordsPage.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(recordsPage.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AutomobilDTO> get(@PathVariable Long id) {

		Automobil artikal = autoService.findOne(id);

		return new ResponseEntity<>(toDTO.convert(artikal), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AutomobilDTO> add(@Validated @RequestBody AutomobilDTO newAuto) {

		Automobil persisted = autoService.save(toAuto.convert(newAuto));

		autoService.save(persisted);

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<AutomobilDTO> edit(@PathVariable Long id, @RequestBody AutomobilDTO editedAuto) {

		if (id == null || !id.equals(editedAuto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Automobil persisted = autoService.save(toAuto.convert(editedAuto));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AutomobilDTO> delete(@PathVariable Long id) {
		Automobil ar = autoService.findOne(id);
		
		autoService.delete(id);

			return new ResponseEntity<>(toDTO.convert(ar), HttpStatus.NO_CONTENT);

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}")
	public ResponseEntity<Najam> iznajmi(@PathVariable Long id){
		 
		Najam n = autoService.iznajmi(id);
		
		if(n != null) {
			return new ResponseEntity<>(n,
					HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(
					HttpStatus.BAD_REQUEST);
		}
		
	}
			
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

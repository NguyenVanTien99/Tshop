package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.RateDTO;
import com.shopping.services.RateService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rate")
public class RateController {
	
	@Autowired
	RateService rateService;
	
	@PostMapping
	public ResponseEntity<RateDTO> save(@RequestBody RateDTO rateDTO) {

		RateDTO _rateDTO = rateService.save(rateDTO);

		return new ResponseEntity<RateDTO>(_rateDTO, HttpStatus.CREATED);
	}

}

package com.david.fontes.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.fontes.dsvendas.dto.SaleDTO;
import com.david.fontes.dsvendas.dto.SaleSuccessDTO;
import com.david.fontes.dsvendas.dto.SaleSumDTO;
import com.david.fontes.dsvendas.repositories.SellerRepository;
import com.david.fontes.dsvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	SaleService service;
	
	@Autowired
	SellerRepository sellerRepository;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findBypage(Pageable pageable) {
		sellerRepository.findAll();
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/amount-by-seller")
	ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
		List<SaleSumDTO> list = service.amountGroupBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/success-by-seller")
	ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller() {
		List<SaleSuccessDTO> list = service.successGroupBySeller();
		return ResponseEntity.ok(list);
	}
}

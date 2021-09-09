package com.david.fontes.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.fontes.dsvendas.dto.SellerDTO;
import com.david.fontes.dsvendas.entities.Seller;
import com.david.fontes.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repo;
	
	public List<SellerDTO> findAll() {	
		List<Seller> result = (List<Seller>) repo.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
}

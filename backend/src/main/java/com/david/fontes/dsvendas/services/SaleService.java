package com.david.fontes.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.david.fontes.dsvendas.dto.SaleDTO;
import com.david.fontes.dsvendas.entities.Sale;
import com.david.fontes.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository repository;
	
	public Page<SaleDTO> findAll(Pageable pageable){
		Page<Sale> lista = repository.findAll(pageable);
		return lista.map(x -> new SaleDTO(x));
	}
}

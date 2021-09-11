package com.david.fontes.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.fontes.dsvendas.dto.SaleDTO;
import com.david.fontes.dsvendas.dto.SaleSuccessDTO;
import com.david.fontes.dsvendas.dto.SaleSumDTO;
import com.david.fontes.dsvendas.entities.Sale;
import com.david.fontes.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		Page<Sale> lista = repository.findAll(pageable);
		return lista.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller() {
		return repository.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupBySeller() {
		return repository.successGroupBySeller();
	}
	
}

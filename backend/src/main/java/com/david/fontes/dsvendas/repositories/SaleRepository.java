package com.david.fontes.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.david.fontes.dsvendas.dto.SaleSuccessDTO;
import com.david.fontes.dsvendas.dto.SaleSumDTO;
import com.david.fontes.dsvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.david.fontes.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("SELECT new com.david.fontes.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupBySeller();
}

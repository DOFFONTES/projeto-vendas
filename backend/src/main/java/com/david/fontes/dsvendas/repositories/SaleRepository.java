package com.david.fontes.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.fontes.dsvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long>{

}

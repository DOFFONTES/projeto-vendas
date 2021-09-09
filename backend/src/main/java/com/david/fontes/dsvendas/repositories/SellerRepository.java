package com.david.fontes.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.fontes.dsvendas.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{
	
	//<S extends Seller> S save(Seller seller);
}

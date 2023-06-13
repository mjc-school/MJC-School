package com.frankmoley.lil.wisdompet.data.repositories;

import com.frankmoley.lil.wisdompet.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}

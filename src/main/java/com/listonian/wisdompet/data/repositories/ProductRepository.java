package com.listonian.wisdompet.data.repositories;

import com.listonian.wisdompet.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}

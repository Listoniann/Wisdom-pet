package com.listonian.wisdompet.data.repositories;

import com.listonian.wisdompet.data.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
}

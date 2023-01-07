package com.olufunmi.supermarketinventory.data.repositories;

import com.olufunmi.supermarketinventory.data.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByBatchNumber(String batchNumber);
}
